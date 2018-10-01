package com.guidesound.Service.impl;

import com.guidesound.Service.IUserService;
import com.guidesound.dao.IUser;
import com.guidesound.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserService implements IUserService {

    @Resource
    private IUser user;

    @Override
    public User getUserById(int userId) {
        return this.user.getUser(1);
    }
}
