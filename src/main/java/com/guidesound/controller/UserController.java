package com.guidesound.controller;

import com.guidesound.Service.IUserService;
import com.guidesound.models.User;
import com.guidesound.util.ServiceResponse;
import com.guidesound.util.TockenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/add")
    public @ResponseBody ServiceResponse createUser(HttpServletResponse response) {

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

    @RequestMapping(value = "/login")
    public  @ResponseBody ServiceResponse login(HttpServletRequest request, HttpServletResponse response) {


        String unionid = request.getParameter("unionid");
        String name = request.getParameter("name");

        ServiceResponse rep = new ServiceResponse();
        if (unionid == null || name == null) {
            rep.setCode(201);
            rep.setMsg("缺少参数");
            return rep;
        }

        String temp1 = request.getServletContext().getRealPath("/");
        String temp2 = request.getServletContext().getRealPath("../");
        int user_id = userService.login(unionid,name);
        String token = TockenUtil.makeTocken(user_id);
        rep.setCode(200);
        rep.setMsg(temp1+ "  " + temp2);
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
        return rep;
    }

    /**
     * 增加用户粉丝
     * @return
     */
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

    /**
     * 获取粉丝数目
     *
     */

    @RequestMapping(value = "/getfuns")
    public @ResponseBody ServiceResponse getUserFunsNum(HttpServletRequest request) {
        User user = (User)request.getAttribute("user_info");
        String funsIdTemp = request.getParameter("funs_id");
        ServiceResponse rep = new ServiceResponse();
        if(funsIdTemp == null) {
            rep.setCode(201);
            rep.setMsg("缺少参数");
            return rep;
        }
        int funsId = Integer.parseInt(funsIdTemp);
        int num = userService.getFunsNum(funsId);

        rep.setCode(200);
        rep.setMsg("增加funs成功");
        rep.setData(String.valueOf(num));
        return rep;
    }

    /**
     *删除对某人的粉丝
     */
    @RequestMapping(value = "/deletefuns")
    public @ResponseBody ServiceResponse deleteUserFuns(HttpServletRequest request) {
        User user = (User)request.getAttribute("user_info");
        String funsIdTemp = request.getParameter("funs_id");
        ServiceResponse rep = new ServiceResponse();
        if(funsIdTemp == null) {
            rep.setCode(201);
            rep.setMsg("缺少参数");
            return rep;
        }

        int funsId = Integer.parseInt(funsIdTemp);
        userService.deleteFuns(user.getId(),funsId);
        rep.setCode(200);
        rep.setMsg("增加funs成功");
        return rep;
    }

    /**
     *获取关注数目
     */
//    public int getUserFollow(HttpServletRequest request) {
//
//    }

}
