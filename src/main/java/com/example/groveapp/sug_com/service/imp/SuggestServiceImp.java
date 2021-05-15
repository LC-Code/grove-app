package com.example.groveapp.sug_com.service.imp;

import com.example.groveapp.sug_com.dao.SugestRep;
import com.example.groveapp.sug_com.entiry.SuggestCompl;
import com.example.groveapp.sug_com.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SuggestServiceImp  implements SuggestService {
    @Autowired
    SugestRep dao;

    @Override
    public SuggestCompl save(SuggestCompl suggest) {
        suggest.setCreateDate(new Date());
        SuggestCompl save = dao.save(suggest);
        return save;
    }

    @Override
    public List<SuggestCompl> findAllByUserCode(String code) {
        List<SuggestCompl> allByUserCode = dao.findAllByUserCode(code);
        return allByUserCode;
    }

    @Override
    public List<Object> findSimpleListByUserCode(String code) {
        List<Object> simpleListByUserCode = dao.findSimpleListByUserCode(code);
        return simpleListByUserCode;
    }
}
