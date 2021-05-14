package com.example.groveapp.entiry;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "user_name")
    private String userNname;
    @Column(name = "password")
    private String password;
    @Column(name = "id_type")
    private String idType;
    @Column(name = "id_cord")
    private String idCode;
    @Column(name = "user_sex")
    private String userSex;
    @Column(name = "user_eduction")
    private String userEduction;
    @Column(name = "user_birthday")
    private Date userBirthday;
    @Column(name = "industry")
    private String industry;
    @Column(name = "profession")
    private String profession;
    @Column(name = "create_date")
    private Date CreateDate;
    @Column(name = "tel_number")
    private String telNumber;


}
