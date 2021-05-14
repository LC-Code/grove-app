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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class UserServiceImp implements UserService {
    Log log = LogFactory.getLog(UserServiceImp.class);
    @Autowired
    UserRepository userDao;
    @Autowired
    RedisService redisService;

    @Autowired
    JdbcTemplate template;

    @Override
   // @Cacheable("#UserInfo.id")
    public UserInfo findUserById(String code) {
        Object value = redisService.get("user::"+code);
        if(value!=null){
            log.info("缓存中存在关于"+code+"的user数据");
            return (UserInfo) value;
        }else{
            log.info("缓存中不存在关于"+code+"的user数据");
            UserInfo byId = userDao.finduserInfoByCode(code);
            redisService.set("user::"+code,byId);
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
        }else {
            log.info("缓存中不存在关于" + code + "的user数据");
            UserInfo byCode = userDao.finduserInfoByCode(code);
            redisService.set("user:" + code, byCode);
            return byCode;

        }
    }

    @Override
    public int updateUserInfoBysql(UserInfo userInfo) {
        log.info(userInfo);
        int i = userDao.updateUserInfo(userInfo.getName(),
                userInfo.getSex(),
                userInfo.getEducation(),
                userInfo.getBirthday(),
                userInfo.getProfession(),
                userInfo.getIndustry(),
                userInfo.getTelNumber(),
                userInfo.getCode());
        return i;
    }

    @Override
    public int MySaveUser(UserInfo userInfo) {
        String sql ="insert into user_info (user_code,user_name,user_sex,user_eduction,user_birthday,industry,profession) values(?,?,?,?,?,?,?)";
        String userIsExsist = userDao.findUserIsExsist(userInfo.getCode());
        if(userIsExsist=="" || userIsExsist == null){
            template.update(sql,new Object[]{userInfo.getCode(),
                                            userInfo.getName(),
                                            userInfo.getSex(),
                                           userInfo.getEducation(),
                                            userInfo.getBirthday(),
                                            userInfo.getIndustry(),
                                            userInfo.getProfession()});
        }
        return 0;
    }


}
