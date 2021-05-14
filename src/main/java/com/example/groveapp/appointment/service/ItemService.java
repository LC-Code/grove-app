package com.example.groveapp.appointment.service;

import com.example.groveapp.appointment.entiry.AppointmentItem;

import java.util.List;

public interface ItemService {
    List<AppointmentItem> findAllByDepartCode(String code);
    List<AppointmentItem> findAll();

}
