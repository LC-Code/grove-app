package com.example.groveapp.service.imp;

import com.example.groveapp.dao.UserRepository;
import com.example.groveapp.entiry.UserInfo;
import com.example.groveapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userDao;
    @Override
    @Cacheable("#UserInfo.id")
    public UserInfo findUserById(String code) {
        UserInfo byId = userDao.findByCode(code);
        return byId;
    }

    @Override
    @Cacheable("#user.id")
    public UserInfo saveUser(UserInfo user) {
        UserInfo cacheUser = (UserInfo) userDao.save(user);
        return cacheUser;
    }
}
