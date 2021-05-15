package com.example.groveapp.depart.service.imp;

import com.example.groveapp.depart.dao.DepartReq;
import com.example.groveapp.depart.entiry.GoveDepart;
import com.example.groveapp.depart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImp implements DepartService {
    @Autowired
    DepartReq dao;
    @Override
    public List<GoveDepart> findAll() {
        List<GoveDepart> all = dao.findAll();
        return all;
    }

    @Override
    public List<Object> findDepart() {
        List<Object> depart = dao.findDepart();
        return depart;
    }
}
