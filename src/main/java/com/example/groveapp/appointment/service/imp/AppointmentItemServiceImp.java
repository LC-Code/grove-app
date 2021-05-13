package com.example.groveapp.appointment.service.imp;

import com.example.groveapp.appointment.dao.AppointmentItemRepository;
import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.appointment.service.AppointmentItemService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.codec.json.KotlinSerializationJsonEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.Cache;

import java.util.List;

@Service
@Transactional
public class AppointmentItemServiceImp implements AppointmentItemService {
    Log log = LogFactory.getLog(AppointmentItemServiceImp.class);
    @Autowired
    AppointmentItemRepository itemDao;

    @Override
    public List<AppointmentItem> getAll() {
        return null;
    }

    @Override
    public AppointmentItem getItemByCode(String code) {
        return null;
    }

    @Override
    public List<AppointmentItem> saveAll(List<AppointmentItem> items) {
       /* for(AppointmentItem item:items){

            itemDao.save(item);
        }*/
       /* List<AppointmentItem> appointmentItems = new ArrayList<>();
        GoveDepart depart = null;
        for (AppointmentItem item : items){
            String itemCode = UUID.randomUUID().toString().replaceAll("-","");
            log.info("item is Code : " +itemCode);
            item.setCode(itemCode);
            GoveDepart itemDepart = item.getDepart();
            if(depart == null){
                depart = itemDepart;
                String departCode = UUID.randomUUID().toString().replaceAll("-","");
                log.info("depart is code ："+ departCode);
                depart.setPart_code(departCode);
            }else{
               if(!(depart.getPart_name().equals(itemDepart.getPart_name()))){
                   depart = itemDepart;
                   String departCode = UUID.randomUUID().toString().replaceAll("-","");
                   log.info("depart is code ："+ departCode);
                   depart.setPart_code(departCode);
               }
            }
            item.setDepart(depart);
            log.info("即将存入的数据 ： "+ item.toString());
            AppointmentItem save = itemDao.save(item);
            if(save != null){
                appointmentItems.add(save);
            }

        }*/
      /*  List<AppointmentItem> appointmentItems = itemDao.saveAll(items);*/
//        return appointmentItems;
        return null;
    }

    @Override
//    @Cacheable(value = "item",key = "#code")
    public List<Object> getItemByDepartCode(String code) {
        List<Object> items = itemDao.findAppointmentItemByDepartCode(code);
        return items;
    }
}
