package com.guidesound.controller;

import com.guidesound.Service.IUserService;
import com.guidesound.models.User;
import com.guidesound.util.ServiceResponse;
import com.guidesound.util.TockenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.mybatis.spring.mapper.MapperFactoryBean;


/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

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
     * @param
     * @return 登录结果
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  @ResponseBody ServiceResponse login(String unionid,String name) {
        ServiceResponse rep = new ServiceResponse();
        if (unionid == null || name == null) {
            rep.setCode(201);
            rep.setMsg("缺少参数");
            return rep;
        }
        int user_id = userService.login(unionid,name);
        String token = TockenUtil.makeTocken(user_id);
        rep.setCode(200);
        rep.setMsg("登录成功");
        rep.setData(token);
        return rep;
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping(value = "/logout")
    public  @ResponseBody ServiceResponse logout(HttpServletRequest request, HttpServletResponse response) {
        ServiceResponse rep = new ServiceResponse();
        System.out.println(currentUser);
        rep.setCode(200);
        rep.setMsg("用户退出");
//        System.out.println(123);
//        User user = (User)request.getAttribute("user_info");
//        System.out.println(user);
        return rep;
    }

    @RequestMapping(value = "/addfuns")
    public @ResponseBody ServiceResponse addFuns(HttpServletRequest request) {
        User user = (User)request.getAttribute("user_info");
        String funsIdTemp = request.getParameter("funs_id");
        ServiceResponse rep = new ServiceResponse();
        if(funsIdTemp == null) {
            rep.setCode(201);
            rep.setMsg("缺少参数");
            return rep;
        }
        int funsId = Integer.parseInt(funsIdTemp);
        userService.addFuns(user.getId(),funsId);
        rep.setCode(200);
        rep.setMsg("增加funs成功");
        return rep;

    }

}
