package com.guidesound.Service;

import com.guidesound.models.User;

import java.util.List;

public interface IUserService {

    public User getUserById(int userId);
    public void insertUser(User user);
    public List<User> getUserList(User user);
    public User updateUser(User user);
    public void deleteUser(int id);


    public int login(String uuid,String name);
    public void addFuns(int userId,int funsUserId);
    public int getFunsNum(int userId);
    public void deleteFuns(int userId,int funsUserId);
}
