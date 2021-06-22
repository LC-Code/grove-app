package com.example.groveapp.service.imp;

import com.example.groveapp.dao.UserRepository;
import com.example.groveapp.entiry.UserInfo;
import com.example.groveapp.service.RedisService;
import com.example.groveapp.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class UserServiceImp implements UserService {


    Log log = LogFactory.getLog(UserServiceImp.class);
    @Autowired
    UserRepository userDao;
    @Autowired
    RedisService service;

    @Value("myParam.open_cache")
    String openCache;

    /*@Override
    @Cacheable("#UserInfo.id")
    public UserInfo findUserById(String code) {
        UserInfo byId = userDao.findByCode(code);
        return byId;
    }*/

    @Override
    public UserInfo findUserByCode(String userCode) {
        UserInfo one = null;
        if(userCode.trim() != null || userCode.trim() != ""){
            if("true".equals(openCache)){
                Object o = service.get("user::"+userCode);
                if(o != null){
                    log.info("缓存数据为"+o.toString());
                   try {
                       one = (UserInfo) o;
                   }catch (Exception e){
                       e.printStackTrace();
                   }finally {
                       one = userDao.getOne(userCode);
                       return one;
                   }

                }else {
                    one  = userDao.getOne(userCode);
                    service.set("user::"+userCode,one,3, TimeUnit.MINUTES);
                }
            }else{
                one  = userDao.getOne(userCode);
            }
            return one;

          /*  Object o = service.get("user::"+userCode);
            if(o != null){
                return (UserInfo) o;
            }else {
                UserInfo one = userDao.getOne(userCode);
                service.set("user::"+userCode,one,3, TimeUnit.MINUTES);
                return one;
            }*/
        }
        return one;
    }

    @Override
//    @Cacheable("#user.id")
    public UserInfo saveUser(UserInfo user) {
        if("true".equals(openCache)){
            UserInfo cacheUser = (UserInfo) userDao.save(user);
            service.set("user::"+cacheUser.getUserCode(),cacheUser,3,TimeUnit.MINUTES);
            return cacheUser;
        }else{
            return userDao.save(user);
        }
       /* UserInfo cacheUser = (UserInfo) userDao.save(user);
        service.set("user::"+cacheUser.getUserCode(),cacheUser,3,TimeUnit.MINUTES);
        return cacheUser;*/
    }
}
