package com.example.groveapp.sug_com.service;

import com.example.groveapp.sug_com.entiry.Consult;

import java.util.List;

public interface ConsultService {
    Consult saveConsul(Consult consult);
    List<Consult> findAllByUserCode(String code);
}
