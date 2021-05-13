package com.example.groveapp.dao;

import com.example.groveapp.entiry.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,String> {

    @Query("select u from UserInfo u where u.code=?1")
    UserInfo finduserInfoByCode(String code);


}
