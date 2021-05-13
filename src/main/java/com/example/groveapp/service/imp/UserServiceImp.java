package com.example.groveapp.service.imp;

import com.example.groveapp.dao.UserRepository;
import com.example.groveapp.entiry.UserInfo;
import com.example.groveapp.service.RedisService;
import com.example.groveapp.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    Log log = LogFactory.getLog(UserServiceImp.class);
    @Autowired
    UserRepository userDao;
    @Autowired
    RedisService redisService;

    @Override
    @Cacheable("#UserInfo.id")
    public UserInfo findUserById(String code) {
        Object value = redisService.get("user:"+code);
        if(value!=null){
            log.info("缓存中存在关于"+code+"的user数据");
            return (UserInfo) value;
        }else{
            log.info("缓存中不存在关于"+code+"的user数据");
            UserInfo byId = userDao.finduserInfoByCode(code);
            redisService.set("user:"+code,byId);
            return byId;
        }
    }

    @Override
    @CachePut(value = "user",key = "#user.code")
    public UserInfo saveUser(UserInfo user) {
        log.info(user);
        UserInfo cacheUser = userDao.save(user);
      /*  cacheUser.setName("测试是否跟新");
        UserInfo save = userDao.save(cacheUser);*/
        redisService.set("user:"+user.getCode(),cacheUser);
        return cacheUser;
    }

    @Override
    @Cacheable(value = "user",key = "#code")
    public UserInfo findUserByCode(String code) {
        Object value = redisService.get("user:"+code);
        if(value!=null) {
            log.info("缓存中存在关于 "+code+" 的user数据");
            log.info("缓存中的数据 : "+value.toString());
            return (UserInfo) value;
        }else{
            log.info("缓存中不存在关于"+code+"的user数据");
            UserInfo byCode = userDao.finduserInfoByCode(code);
            redisService.set("user:"+code,byCode);
            return byCode;

        }

    }
}
