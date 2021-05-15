package com.example.groveapp.appointment.dao;

import com.example.groveapp.appointment.entiry.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRep extends JpaRepository<Appointment,String> {

    List<Appointment> findAllByUserCode(String userCode);

    @Override
    <S extends Appointment> S save(S entity);

    @Query("select " +
            "a.createDate," +
            "item.itemName," +
            "a.appTime," +
            "a.appTimeAm," +
            "a.acceptTime," +
            "a.evaluate," +
            "d.partName," +
            "a.appCode "+
            "from  Appointment a,AppointmentItem item,GoveDepart d " +
            "where a.itemCode=item.itemCode and a.userCode=?1 and a.isAccept = ?2 and item.partCode = d.partCode")
    List<Object> findNoAceept(String code,String isAccept);


}
