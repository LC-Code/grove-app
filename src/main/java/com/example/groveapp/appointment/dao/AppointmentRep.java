package com.example.groveapp.appointment.dao;

import com.example.groveapp.appointment.entiry.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRep extends JpaRepository<Appointment,String> {

    List<Appointment> findAllByUserCode(String userCode);

    @Override
    <S extends Appointment> S save(S entity);


}
