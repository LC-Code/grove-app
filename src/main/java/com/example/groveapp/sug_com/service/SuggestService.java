package com.example.groveapp.sug_com.service;

import com.example.groveapp.sug_com.entiry.SuggestCompl;

import java.util.List;

public interface SuggestService {
    SuggestCompl save(SuggestCompl suggest);

    List<SuggestCompl> findAllByUserCode(String code);
}
