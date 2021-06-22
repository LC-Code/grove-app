package com.example.groveapp.controller;

import com.example.groveapp.entiry.UserInfo;
import com.example.groveapp.entiry.WxLoginRespond;
import com.example.groveapp.service.LoginService;
import com.example.groveapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
public class UserController {

    Log log = LogFactory.getLog(UserController.class);
    //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    @Autowired
    ObjectMapper mapper;
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;
    @Autowired
    RestTemplateBuilder builder;

    @GetMapping(path = "/login/{code}.json")
    public WxLoginRespond login(@PathVariable String code) throws IOException {
        WxLoginRespond seesionKeyAndOpenId = loginService.getSeesionKeyAndOpenId(code);
        return seesionKeyAndOpenId;
    }

    @GetMapping("/user/find/{code}.json")
    public UserInfo getOneUser(@PathVariable String code){
        if(code != null){
            log.info("用户code "+code );
            UserInfo userByCode = userService.findUserByCode(code);
            return userByCode;
        }
       return null;
    }

    @PostMapping("/user/save.do")
    public UserInfo saveUser(@RequestBody UserInfo userInfo){
        UserInfo userInfo1 = userService.saveUser(userInfo);
        return userInfo;
    }
}
