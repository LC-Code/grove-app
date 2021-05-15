package com.example.groveapp.appointment.service.imp;

import com.example.groveapp.appointment.dao.ItemRep;
import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.appointment.service.ItemService;
import com.example.groveapp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class ItemServiceImp implements ItemService {
    @Autowired
    ItemRep itemDao;
    @Autowired
    RedisService redisService;
  /*  @Override
    public List<AppointmentItem> findAllByDepartCode(String code) {
        List<AppointmentItem> allByPartCode = itemDao.findAllByPartCode(code);
        return allByPartCode;
    }
*/
    @Override
    public List<AppointmentItem> findAll() {
        List<AppointmentItem> all = itemDao.findAll();
        return all;
    }

    @Override
    @Cacheable(value = "item",key = "#code")
    public List<Object> findAllByDepartCode(String code) {
        Object o = redisService.get("item::" + code);
        if(o != null){
            return (List<Object>) o;
        }else{
            List<Object> allByPartCode = itemDao.findAllByPartCode(code);
            redisService.set("item::" + code,allByPartCode,1, TimeUnit.HOURS);
            return allByPartCode;
        }
    }
}
