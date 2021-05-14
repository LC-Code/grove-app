package com.example.groveapp.sug_com.dao;

import com.example.groveapp.sug_com.entiry.SuggestCompl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugestRep extends JpaRepository<SuggestCompl,String> {
    @Override
    <S extends SuggestCompl> S save(S entity);

    List<SuggestCompl> findAllByUserCode(String code);
}
