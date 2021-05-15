package com.example.groveapp.depart.controller;

import com.example.groveapp.depart.entiry.GoveDepart;
import com.example.groveapp.depart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartController {
    @Autowired
    DepartService service;

   /* @GetMapping("/depart/findAll.json")
    public List<GoveDepart> findAll(){
        List<GoveDepart> all = service.findAll();
        return all;
    }*/
    @GetMapping("/depart/findAll.json")
    public List<Object> findAll(){
        List<Object> all = service.findDepart();
        return all;
    }
}
