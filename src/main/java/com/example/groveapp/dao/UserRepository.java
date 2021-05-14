package com.example.groveapp.dao;

import com.example.groveapp.entiry.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,String> {

    @Query("select u.code,u.name,u.birthday,u.education,u.idCode,u.industry,u.sex,u.profession,u.telNumber from UserInfo u where u.code=?1")
    UserInfo finduserInfoByCode(String code);
    @Modifying
   @Query("update UserInfo u set u.name = :name,u.sex = :sex,u.education = :education," +
           "u.birthday = :birthday,u.profession = :profession,u.industry=:industry," +
           "u.telNumber =:telNumber where u.code=:code")
    int updateUserInfo(String name, String sex,
                       String education, Date birthday,
                       String profession,String industry,
                       String telNumber,String code);
    @Query("select u.name from UserInfo u where u.code = ?1")
    String findUserIsExsist(String code);

   /* @Query(value = "insert into user_info (user_code,user_name,user_sex,user_eduction,user_birthday,industry,profession)" +
            " values(?,?,?,?,?,?,?)" )*/
    UserInfo mySaveUser(UserInfo userInfo);

}
