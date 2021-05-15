package com.example.groveapp.sug_com.service.imp;

import com.example.groveapp.sug_com.dao.ConsultRep;
import com.example.groveapp.sug_com.entiry.Consult;
import com.example.groveapp.sug_com.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ConsultSerciceImp implements ConsultService {

    @Autowired
    ConsultRep dao;
    @Override
    public Consult saveConsul(Consult consult) {
        consult.setCreatDate(new Date());
        Consult save = dao.save(consult);
        return save;
    }

    @Override
    public List<Consult> findAllByUserCode(String code) {
        List<Consult> allByUserCode = dao.findAllByUserCode(code);
        return allByUserCode;
    }

    @Override
    public List<Object> findSimpleListByUserCode(String code) {
        List<Object> simpleListByUserCode = dao.findSimpleListByUserCode(code);
        return simpleListByUserCode;
    }

}
