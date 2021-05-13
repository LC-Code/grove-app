package com.example.groveapp.depart.controller;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.depart.entiry.GoveDepart;
import com.example.groveapp.depart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
public class DepartController {

    @Autowired
    DepartService service;

    @GetMapping(path = "/depart/findAll.json")
    public List<GoveDepart> getAll(){
        List<GoveDepart> all = service.getAll();
        return all;
    }

    @GetMapping(path = "/depart/find/{code}.json")
    public GoveDepart findOneByCode(@PathVariable String code){
        return service.findDepartByCode(code);
    }

   /* @PostMapping(path = "/depart/saveAll.json")*/
    /*public long saveAll(@RequestBody List<GoveDepart> departs){
        int count=0;
        for (GoveDepart depart: departs){
            String code = UUID.randomUUID().toString().replaceAll("-", "");
            depart.setPart_code(code);
            Set<AppointmentItem> items = depart.getItems();
            Set<AppointmentItem> addItems = new HashSet<>();
            for (AppointmentItem item:items){
                item.setCode(code = UUID.randomUUID().toString().replaceAll("-", ""));
                addItems.add(item);
            }
          *//*  depart.setItems(addItems);*//*
            GoveDepart save = service.save(depart);
            if(save != null){
                count ++;
            }
        }
        return count;
    }*/
}
