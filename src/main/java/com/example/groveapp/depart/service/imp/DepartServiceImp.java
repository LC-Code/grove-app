package com.example.groveapp.depart.service.imp;

import com.example.groveapp.depart.dao.DepartReq;
import com.example.groveapp.depart.entiry.GoveDepart;
import com.example.groveapp.depart.service.DepartService;
import com.example.groveapp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DepartServiceImp implements DepartService {
    @Autowired
    DepartReq dao;
    @Autowired
    RedisService service;

    @Override
    public List<GoveDepart> findAll() {
        List<GoveDepart> all = dao.findAll();
        return all;
    }

    @Override
    public List<Object> findDepart() {
        Object o = service.get("depart::allDepart");
        if(o != null){
            return (List<Object>) o;
        }else{
            List<Object> depart = dao.findDepart();
            service.set("depart::allDepart",depart,10, TimeUnit.MINUTES);
            return depart;
        }
    }
}
