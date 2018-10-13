package com.guidesound.controller;

import com.guidesound.util.ServiceResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/edit")
public class EditController {

    @RequestMapping(value = "/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, HttpServletResponse response) throws IOException {


        System.out.println(1234);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile picture = multipartRequest.getFile("upload");
        System.out.println(picture);
        if(picture == null) {
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setCode(201);
            serviceResponse.setMsg("缺少参数");
            serviceResponse.data = null;
            return serviceResponse;
        }
        String savePath = multipartRequest.getServletContext().getRealPath("");
        System.out.println(savePath);
        File file = new File(savePath);
        savePath = file.getParent() + "/edit_upload";

        File filePath = new File(savePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdir();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss_");//设置日期格式
        String strDate = df.format(new Date());// new Date()为获取当前系统时间
        String pathPic = savePath + "/" + strDate + picture.getOriginalFilename();

        picture.transferTo(new File(pathPic));

        String showPicPath = "http://" + request.getServerName()
                + ":"+ request.getServerPort()
                + "/edit_upload"
                + "/" + strDate
                + picture.getOriginalFilename();

//        return null;
        System.out.println(showPicPath);
        EditResp editResp = new EditResp();
        editResp.setFileName(picture.getOriginalFilename());
        editResp.setUploaded(1);
        editResp.setUrl("/edit_upload/" + strDate + picture.getOriginalFilename());
        return editResp;
    }
    @RequestMapping(value = "/browse")
    public void browse(){
    }

}

class EditResp {
    String fileName;
    int uploaded;
    String url;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getUploaded() {
        return uploaded;
    }

    public void setUploaded(int uploaded) {
        this.uploaded = uploaded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
