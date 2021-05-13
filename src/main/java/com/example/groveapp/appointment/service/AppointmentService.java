package com.example.groveapp.appointment.service;

import com.example.groveapp.appointment.entiry.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> findAll();
}
