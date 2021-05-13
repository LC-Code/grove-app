package com.example.groveapp.controller;

import com.example.groveapp.entiry.UserInfo;
import com.example.groveapp.entiry.WxLoginRespond;
import com.example.groveapp.service.LoginService;
import com.example.groveapp.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.shape.Path;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;


@RestController
public class UserController {

    Log log = LogFactory.getLog(UserController.class);
    //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    @Autowired
    ObjectMapper mapper;
    @Autowired
    UserService service;
    @Autowired
    RestTemplateBuilder builder;
    @Autowired
    LoginService loginService;

    @GetMapping(path = "/login/{code}.json")
    public WxLoginRespond login(@PathVariable String code) throws IOException {
        WxLoginRespond seesionKeyAndOpenId = loginService.getSeesionKeyAndOpenId(code);
        log.info("返回的sessionKey,openId"+seesionKeyAndOpenId.toString());
        return seesionKeyAndOpenId;
    }

    @PostMapping(path = "/save/user.do")
    public com.example.groveapp.entiry.UserInfo SaveUser(@RequestBody com.example.groveapp.entiry.UserInfo userInfo){
       log.info("微信端传来的数据："+userInfo.toString());
        return service.saveUser(userInfo);

    }

    @GetMapping(path = "/find/user/{code}.do")
    @Transactional
    public com.example.groveapp.entiry.UserInfo findUser(@PathVariable String code){
        log.info("根据code查询user数据" + code);
        com.example.groveapp.entiry.UserInfo userByCode = this.service.findUserByCode(code);
        log.info(userByCode.getCode());
        return userByCode;
    }
}
