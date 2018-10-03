package com.guidesound.controller;

import com.guidesound.Service.IVideoService;
import com.guidesound.models.User;
import com.guidesound.models.Video;
import com.guidesound.util.ServiceResponse;
import com.sun.xml.internal.ws.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 视频控制器
 */

@Controller
@RequestMapping("/video")
public class VideoController extends BaseController {

    @Autowired
    private IVideoService videoService;

    /**
     * 视频上传
     */
    @RequestMapping(value = "/add")
    public @ResponseBody
    ServiceResponse addVideo(HttpServletRequest request) throws IOException {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String title = multipartRequest.getParameter("title");
        String subject = multipartRequest.getParameter("subject");
        String watch_type = multipartRequest.getParameter("watch_type");
        String content = multipartRequest.getParameter("content");
        MultipartFile picture = multipartRequest.getFile("picture");
        MultipartFile viedo = multipartRequest.getFile("video");

        if (
                title == null
                        || subject == null
                        || watch_type == null
                        || viedo == null
                        || picture == null
                        || content == null
                ) {
            ServiceResponse rsp = new ServiceResponse();
            rsp.msg = "缺少参数";
            rsp.code = 201;
            return rsp;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss_");//设置日期格式
        String strDate = df.format(new Date());// new Date()为获取当前系统时间

        String savePath = multipartRequest.getServletContext().getRealPath("");
        savePath = savePath.substring(0,savePath.lastIndexOf("webapps") + 8) + "upload";


        System.out.println(savePath);
        System.out.println("22211");

        File filePath = new File(savePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdir();
        }
        String pathPic = savePath + "/" + strDate + picture.getOriginalFilename();
        String pathCon = savePath + "/" + strDate + viedo.getOriginalFilename();
        System.out.println(pathPic);
        System.out.println(pathCon);
        //上传
        picture.transferTo(new File(pathPic));
        viedo.transferTo(new File(pathCon));

        Video video = new Video();
        User user = (User)multipartRequest.getAttribute("user_info");
        video.setUser_id(user.getId());
        video.setTitle(title);
        video.setSubject(Integer.parseInt(subject));
        video.setWatch_type(Integer.parseInt(watch_type));
        video.setContent(content);

        String picNetPath = multipartRequest.getContextPath();
        System.out.println(picNetPath);
        System.out.println(123);
        String showPicPath = "http://" + request.getServerName()
                + ":"+ request.getServerPort()
                + multipartRequest.getContextPath()
                + "/upload"
                + "/" + strDate
                + picture.getOriginalFilename();
        String videoPicPath = "http://" + request.getServerName()
                + ":"+ request.getServerPort()
                + multipartRequest.getContextPath()
                + "/upload"
                + "/" + strDate
                + viedo.getOriginalFilename();
        video.setPic_up_path(showPicPath);
        video.setVideo_up_path(videoPicPath);

        video.setCreate_time((int) (new Date().getTime() / 1000));
        video.setUpdate_time((int) (new Date().getTime() / 1000));
        videoService.addVideo(video);

        ServiceResponse rsp = new ServiceResponse();
        rsp.msg = "新增视频完成";
        rsp.code = 200;
        return rsp;
    }
}
