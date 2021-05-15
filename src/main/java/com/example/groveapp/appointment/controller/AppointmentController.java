package com.example.groveapp.appointment.controller;

import com.example.groveapp.appointment.entiry.Appointment;
import com.example.groveapp.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentService service;


    @GetMapping("/appointment/find/{userCode}.json")
    public List<Appointment> getAppByUserCode(@PathVariable String userCode){
        List<Appointment> allByUserCode = service.findAllByUserCode(userCode);
        return allByUserCode;
    }

    @PostMapping("/appointment/save.do")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        Appointment sava = service.sava(appointment);
        return sava;
    }

    @GetMapping("/appointment/find/{userCode}/{isAccept}.json")
    public List<Object> findNoAceept(@PathVariable String userCode,@PathVariable String isAccept){
        List<Object> noAceept = service.findNoAceept(userCode, isAccept);
        return noAceept;
    }


}
