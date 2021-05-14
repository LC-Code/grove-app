package com.example.groveapp.appointment.service;

import com.example.groveapp.appointment.entiry.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAllByUserCode(String userCode);
    Appointment sava(Appointment appointment);
    List<Appointment> findAll();

}
