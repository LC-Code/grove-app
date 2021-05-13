package com.example.groveapp.appointment.controller;

import com.example.groveapp.appointment.entiry.Appointment;
import com.example.groveapp.appointment.service.AppointmentService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {
    Log log = LogFactory.getLog(AppointmentController.class);
    @Autowired
    AppointmentService service;

    @PostMapping(path = "/appiontment/save.do")
    public Appointment toSaveAppoinment(@RequestBody Appointment appointment){
        log.info("从微信端接收的数据"+appointment.toString());
        Appointment appoint = service.saveAppointment(appointment);
        return appoint;
    }

    @GetMapping(path = "/appointment/findAll.json")
    public List<Appointment> findAll(){
        return service.findAll();
    }



}
