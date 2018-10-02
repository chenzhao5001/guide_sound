package com.guidesound.controller;

import com.guidesound.Service.IUserService;
import com.guidesound.models.User;
import com.guidesound.util.TockenUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected User currentUser;
    @Resource
    private IUserService userService;

    @ModelAttribute
    public void common(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getParameter("token");
        if(token != null) {
            int user_id = TockenUtil.getUserIdByTocket(token);
            currentUser = userService.getUserById(user_id);
        }
    }
}
