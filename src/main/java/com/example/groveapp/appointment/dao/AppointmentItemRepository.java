package com.example.groveapp.appointment.dao;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentItemRepository extends JpaRepository<AppointmentItem,String> {
    @Override
    <S extends AppointmentItem> S save(S entity);

    @Override
    <S extends AppointmentItem> List<S> saveAll(Iterable<S> entities);

    @Override
    List<AppointmentItem> findAll();

    AppointmentItem findAppointmentItemByCode(String code);
    @Query("select item.code,item.itemName,item.disposeType from AppointmentItem item where item.depart.part_code = ?1")
    List<Object> findAppointmentItemByDepartCode(String code);

//    List<AppointmentItem> findAppointmentItemByCode(String code)
}
