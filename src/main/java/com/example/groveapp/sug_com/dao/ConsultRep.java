package com.example.groveapp.sug_com.dao;

import com.example.groveapp.sug_com.entiry.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultRep extends JpaRepository<Consult,String> {
    @Override
    <S extends Consult> S save(S entity);

    List<Consult> findAllByUserCode(String code);
}
