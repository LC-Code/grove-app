package com.example.groveapp.appointment.dao;

import com.example.groveapp.appointment.entiry.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRep extends JpaRepository<Appointment,String> {
    @Override
    <S extends Appointment> S save(S entity);
}
