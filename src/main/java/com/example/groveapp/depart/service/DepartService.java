package com.example.groveapp.depart.service;

import com.example.groveapp.depart.entiry.GoveDepart;

import java.util.List;

public interface DepartService {
    List<GoveDepart> getAll();
    List<GoveDepart> saveAll(List<GoveDepart> departs);
    GoveDepart save(GoveDepart depart);
    GoveDepart findDepartByCode(String code);
}
