package com.example.groveapp.appointment.dao;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRep extends JpaRepository<AppointmentItem,String> {

    @Query("select a.itemName from AppointmentItem a where a.itemCode = ?1")
    String findItemNameByItemCode(String itemCode);

    @Override
    List<AppointmentItem> findAll();

    List<AppointmentItem> findAllByPartCode(String code);
}
