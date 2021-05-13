package com.example.groveapp.appointment.controller;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.example.groveapp.appointment.service.AppointmentItemService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    Log log = LogFactory.getLog(ItemController.class);
    @Autowired
    AppointmentItemService service;

    @PostMapping(path = "/item/saveAll.json")
    public int saveItemAll(@RequestBody List<AppointmentItem> items){
        log.info("item 后端接收到的数据："+items.toString());
        List<AppointmentItem> appointmentItems = service.saveAll(items);
        return appointmentItems.size();
    }

    @GetMapping(path = "/item/getAll/{departCode}.json")
    public List<Object> getItems(@PathVariable String departCode){
        List<Object> items = service.getItemByDepartCode(departCode);
        return items;
    }

}
