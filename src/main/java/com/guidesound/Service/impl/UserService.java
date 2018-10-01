package com.guidesound.Service.impl;

import com.guidesound.Service.IUserService;
import com.guidesound.dao.IUser;
import com.guidesound.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUser user;

    @Override
    public User getUserById(int userId) {
        return this.user.getUser(userId);
    }

    @Override
    public void insertUser(User user) {
        this.user.insertUser(user);
    }

    @Override
    public List<User> getUserList(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public int login(String uuid,String name) {
        List<User> userList = this.user.getListByUnionid(uuid);
        System.out.println(userList);
        if(null == userList || userList.size() ==0 ){
            User u_temp = new User();
            u_temp.setUnionid(uuid);
            u_temp.setName(name);
            u_temp.setType(0);
            u_temp.setStatus(0);
            u_temp.setFollow_num(0);
            u_temp.setFuns_num(0);
            u_temp.setSign_name("");
            u_temp.setSex(0);
            u_temp.setTeach_age(0);
            u_temp.setCreate_time((int) (new Date().getTime() / 1000));
            u_temp.setUpdate_time((int) (new Date().getTime() / 1000));
            this.user.insertUser(u_temp);
            return u_temp.getId();
        }
        return userList.get(0).getId();
    }

}
