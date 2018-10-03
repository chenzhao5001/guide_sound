package com.guidesound.controller;

import com.guidesound.util.ServiceResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 视频控制器
 */

@Controller
@RequestMapping("/video")
public class VideoController extends BaseController{

    /**
     * 视频上传
     */
    @RequestMapping(value = "/add")
    public @ResponseBody ServiceResponse addVideo(HttpServletRequest request) throws IOException {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String title = multipartRequest.getParameter("title");
        String subject = multipartRequest.getParameter("subject");
        String watch_type = multipartRequest.getParameter("watch_type");
        MultipartFile picture = multipartRequest.getFile("picture");
        MultipartFile content = multipartRequest.getFile("content");

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss_");//设置日期格式
        String strDate = df.format(new Date());// new Date()为获取当前系统时间

        String savePath = multipartRequest.getServletContext().getRealPath("/up_video");
        System.out.println(savePath);
        File filePath =new File(savePath);
        if  (!filePath .exists()  && !filePath .isDirectory()) {
            filePath .mkdir();
        }
        String pathPic = savePath + "/"+ strDate + picture.getOriginalFilename();
        String pathCon = savePath + "/"+ strDate + content.getOriginalFilename();
        System.out.println(pathPic);
        System.out.println(pathCon);
        //上传
        picture.transferTo(new File(pathPic));
        content.transferTo(new File(pathCon));


        ServiceResponse rsp = new ServiceResponse();
        rsp.msg = "ass";
        rsp.code = 123;
        return rsp;
    }
}
