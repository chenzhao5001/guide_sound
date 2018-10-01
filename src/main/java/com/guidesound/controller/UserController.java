package com.guidesound.controller;

import com.guidesound.Service.IUserService;
import com.guidesound.models.User;
import com.guidesound.util.ServiceResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

//import org.mybatis.spring.mapper.MapperFactoryBean;


/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public @ResponseBody ServiceResponse createUser() {
        ServiceResponse rsp = new ServiceResponse();
        rsp.msg = "ass";
        rsp.code = 123;
        return rsp;
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  @ResponseBody ServiceResponse login(String unionid) {
        System.out.println(123);
        ServiceResponse rep = new ServiceResponse();
//        if (unionid == null) {
//            rep.setCode(201);
//            rep.setMsg("缺少参数");
//            return rep;
//        }
        User user = userService.getUserById(1);
        System.out.println(user);


        return null;
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public  @ResponseBody ServiceResponse logout() {
        return null;
    }

}
