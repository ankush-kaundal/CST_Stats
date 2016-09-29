package com.manh.dao;

import com.manh.model.User;

public interface IUserDetailsDao {
    public boolean createUserDetail(User user);
    public boolean isUserAlreadyCreated(User user);
    public boolean isValidUser(User user);
    public String getUserName(User user);
}