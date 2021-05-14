package com.example.groveapp.appointment.controller;

import com.example.groveapp.appointment.entiry.Appointment;
import com.example.groveapp.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
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
}
