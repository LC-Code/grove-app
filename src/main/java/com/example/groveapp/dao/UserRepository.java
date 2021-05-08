package com.example.groveapp.dao;

import com.example.groveapp.entiry.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    @Query("select u from UserInfo u where u.code=?1")
    UserInfo findByCode(String Code);

}
