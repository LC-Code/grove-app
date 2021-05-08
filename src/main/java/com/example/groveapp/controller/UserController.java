package com.example.groveapp.controller;

import com.example.groveapp.entiry.WxLoginRespond;
import com.example.groveapp.service.UserService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
    @Value("${wx.appId}")
    String appId;
    @Value("${wx.appSecret}")
    String appSecret;
    @Value("${wx.grantType}")
    String grantType;
    @Value("${wx.baseUrl}")
    String baseUrl;

    @GetMapping(path = "/login/{code}.json")
    public Object login(@PathVariable String code) throws IOException {
        log.info("login 方法执行接收到的数据为"+code);
        RestTemplate template = builder.build();
        Map<String,String> map = new HashMap<String,String>();
        map.put("appid",appId);
        map.put("secret",appSecret);
        map.put("grant_type",grantType);
        map.put("js_code",code);
        String urls = baseUrl+"?appid="+appId+"&secret="+appSecret+"&grant_type=authorization_code&js_code="+code;
        String url = baseUrl+"?appid={appid}&secret={secret}&grant_type={grant_type}&js_code={js_code}";
        log.info(urls);
        String response = template.getForObject(url,String.class, map);
        /*ParameterizedTypeReference<Map<String, String>> typeReference = new ParameterizedTypeReference<Map<String, String>>(){};
        ResponseEntity<Map<String, String>> exchange = template.exchange(url,
                HttpMethod.GET,
                null,
                typeReference,
                map);*/
        WxLoginRespond wx = new WxLoginRespond();
        JsonNode jsonNode = mapper.readTree(response);
        jsonNode.get("session_key").asText();
        jsonNode.get("openid").asText();



        log.info(response);
        return null;

    }
}
