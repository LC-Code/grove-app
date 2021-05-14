package com.example.groveapp.appointment.dao;

import com.example.groveapp.appointment.entiry.Appointment;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRep extends JpaRepository<Appointment,String> {
    @Override
    <S extends Appointment> S save(S entity);


   /* @Query(value="insert into appointment(app_code,item_code,app_time,app_time_am,user_code) " +
            "values (:appCode,item_code,:app_time,:app_time_am,:user_code)",nativeQuery=true)
    int saveAppointment(@Param("appCode") String appCode,
                        @Param("item_code") String item_code,
                        @Param("app_time") Date app_time,
                        @Param("app_time_am") String app_time_am,
                        @Param("user_code") String user_code);*/
    //int saveAppointment(Appointment app);
    /*int saveAppointment(String appCode,
                         String item_code,
                        Date app_time,
                        String app_time_am,
                        String user_code);*/

}
