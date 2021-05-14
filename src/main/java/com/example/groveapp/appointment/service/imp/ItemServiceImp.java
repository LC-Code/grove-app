package com.example.groveapp.appointment.service.imp;

import com.example.groveapp.appointment.dao.ItemRep;
import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.appointment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ItemServiceImp implements ItemService {
    @Autowired
    ItemRep itemDao;
    @Override
    public List<AppointmentItem> findAllByDepartCode(String code) {
        List<AppointmentItem> allByPartCode = itemDao.findAllByPartCode(code);
        return allByPartCode;
    }

    @Override
    public List<AppointmentItem> findAll() {
        List<AppointmentItem> all = itemDao.findAll();
        return all;
    }
}
