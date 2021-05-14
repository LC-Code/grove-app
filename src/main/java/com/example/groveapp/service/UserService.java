package com.example.groveapp.service;

import com.example.groveapp.entiry.UserInfo;

public interface UserService {
    UserInfo findUserByCode(String userCode);
    UserInfo saveUser(UserInfo user);
}
