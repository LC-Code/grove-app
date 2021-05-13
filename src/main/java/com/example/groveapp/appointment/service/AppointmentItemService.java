package com.example.groveapp.appointment.service;

import com.example.groveapp.appointment.entiry.AppointmentItem;

import java.util.List;

public interface AppointmentItemService {
    List<AppointmentItem> getAll();
    AppointmentItem getItemByCode(String code);
    List<AppointmentItem> saveAll(List<AppointmentItem> items);
    List<Object> getItemByDepartCode(String code);
}