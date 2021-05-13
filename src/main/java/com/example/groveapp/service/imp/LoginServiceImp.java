package com.example.groveapp.service.imp;

import com.example.groveapp.entiry.WxLoginRespond;
import com.example.groveapp.service.LoginService;
import com.example.groveapp.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImp implements LoginService {
    Log log = LogFactory.getLog(LoginServiceImp.class);
    @Autowired
    ObjectMapper mapper;
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
    @Override
//    @Cacheable(value="wxSession",key = "")
    public WxLoginRespond getSeesionKeyAndOpenId(String code) throws JsonProcessingException {
        log.info("login 方法执行接收到的数据为"+code);
        RestTemplate template = builder.build();
        Map<String,String> map = new HashMap<String,String>();
        WxLoginRespond respond = new WxLoginRespond();
        map.put("appid",appId);
        map.put("secret",appSecret);
        map.put("grant_type",grantType);
        map.put("js_code",code);
        String url = baseUrl+"?appid={appid}&secret={secret}&grant_type={grant_type}&js_code={js_code}";
        log.info(url);
        String response = template.getForObject(url,String.class, new String[]{appId,appSecret,grantType,code});
        log.info("wx服务返回的结果：：："+response);
        JsonNode jsonNode = mapper.readTree(response);
        if(jsonNode.has("errcode")) {
            respond.setErrcode(jsonNode.get("errcode").asText());
            respond.setErrmsg(jsonNode.get("errmsg").asText());
        }else{
            respond.setSession_key(jsonNode.get("session_key").asText());
            respond.setOpendid(jsonNode.get("openid").asText());
        }
        return respond;
    }
}
