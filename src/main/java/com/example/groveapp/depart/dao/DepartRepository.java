package com.example.groveapp.depart.dao;

import com.example.groveapp.depart.entiry.GoveDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartRepository extends JpaRepository<GoveDepart,String> {
    @Override
    <S extends GoveDepart> List<S> saveAll(Iterable<S> entities);
    @Override
    List<GoveDepart> findAll();

    @Override
    <S extends GoveDepart> S save(S entity);
    @Query("select d from GoveDepart d where d.part_code=?1")
    GoveDepart findGoveDepartByPart_code(String code);
}
