package com.example.groveapp.appointment.controller;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.appointment.service.ItemService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItmeController {
    Log log = LogFactory.getLog(ItmeController.class);
    @Autowired
    ItemService service;

    @GetMapping("/item/find/{departCode}.json")
    public List<Object> getItemsByDepartCode(@PathVariable String departCode){
        List<Object> allByDepartCode = service.findAllByDepartCode(departCode);
        log.info(allByDepartCode);
        return allByDepartCode;
    }
}
