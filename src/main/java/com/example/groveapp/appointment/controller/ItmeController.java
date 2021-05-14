package com.example.groveapp.appointment.controller;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.appointment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ItmeController {
    @Autowired
    ItemService service;

    @GetMapping("/item/find/{departCode}.json")
    public List<AppointmentItem> getItemsByDepartCode(@PathVariable String departCode){
        List<AppointmentItem> allByDepartCode = service.findAllByDepartCode(departCode);
        return allByDepartCode;
    }
}
