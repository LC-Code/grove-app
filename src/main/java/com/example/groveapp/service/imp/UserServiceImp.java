package com.example.groveapp.service.imp;

import com.example.groveapp.dao.UserRepository;
import com.example.groveapp.entiry.UserInfo;
import com.example.groveapp.service.RedisService;
import com.example.groveapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userDao;
    @Autowired
    RedisService service;

    /*@Override
    @Cacheable("#UserInfo.id")
    public UserInfo findUserById(String code) {
        UserInfo byId = userDao.findByCode(code);
        return byId;
    }*/

    @Override
    public UserInfo findUserByCode(String userCode) {
        if(userCode.trim() != null || userCode.trim() != ""){
            Object o = service.get("user::"+userCode);
            if(o != null){
                return (UserInfo) o;
            }else {
                UserInfo one = userDao.getOne(userCode);
                service.set("user::"+userCode,one,3, TimeUnit.MINUTES);
                return one;
            }
        }
        return null;
    }

    @Override
//    @Cacheable("#user.id")
    public UserInfo saveUser(UserInfo user) {
        UserInfo cacheUser = (UserInfo) userDao.save(user);
        service.set("user::"+cacheUser.getUserCode(),cacheUser,3,TimeUnit.MINUTES);
        return cacheUser;
    }
}
