package com.example.groveapp.depart.service;

import com.example.groveapp.depart.entiry.GoveDepart;

import java.util.List;

public interface DepartService {
    List<GoveDepart> findAll();
    List<Object> findDepart();
}
