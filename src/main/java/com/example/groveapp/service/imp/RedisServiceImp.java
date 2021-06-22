package com.example.groveapp.service.imp;

import com.example.groveapp.service.RedisService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class RedisServiceImp implements RedisService {

    @Resource
    RedisTemplate<String,Object> template;

    @Override
    public void set(String key, Object value,long timeOut,TimeUnit unit) {
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        ValueOperations<String, Object> vo = template.opsForValue();
        vo.set(key, value,timeOut,unit);
    }

    @Override
    public void set(String key, Object value) {
        //more一分钟后过期
        set(key, value,1, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, Object> vo = template.opsForValue();
        Object value = vo.get(key);
        return value;
    }
}