package com.guidesound.dao;

import com.guidesound.models.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUser {
    public List<User> getUserList();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int id);

    public List<User> getListByUnionid(String unionid);

    @Select("select * from user where phone = #{arg0}")
    public List<User> getUserByPhone(String phone);

    @Update("update user set phone = #{arg1},pwd = #{arg2} ,status = 1 where id = #{arg0}")
    public void phoneRegister(int id,String phone,String pwd);




}

