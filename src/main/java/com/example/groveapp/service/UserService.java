package com.example.groveapp.service;

import com.example.groveapp.entiry.UserInfo;
import org.apache.catalina.User;

public interface UserService {
    UserInfo findUserById(String id);
    UserInfo saveUser(UserInfo user);
    UserInfo findUserByCode(String code);
    int updateUserInfoBysql(UserInfo userInfo);
    int MySaveUser(UserInfo userInfo);
}
