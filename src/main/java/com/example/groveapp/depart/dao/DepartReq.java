package com.example.groveapp.depart.dao;

import com.example.groveapp.depart.entiry.GoveDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartReq extends JpaRepository<GoveDepart,String> {
    @Override
    List<GoveDepart> findAll();

    @Query("select d.partCode,d.partName from GoveDepart d")
    List<Object> findDepart();
}
