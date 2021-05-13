package com.example.groveapp.service;

import com.example.groveapp.entiry.UserInfo;

public interface UserService {
    UserInfo findUserById(String id);
    UserInfo saveUser(UserInfo user);
    UserInfo findUserByCode(String code);
}
