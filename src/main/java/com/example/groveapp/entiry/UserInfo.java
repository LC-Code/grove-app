package com.example.groveapp.entiry;

import com.example.groveapp.appointment.entiry.Appointment;
import com.example.groveapp.sug_com.entiry.Consult;
import com.example.groveapp.sug_com.entiry.SuggestCompl;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_code")
    private String code;
    @Column(name = "user_name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "id_type")
    private String idType;
    @Column(name = "id_cord")
    private String idCode;
    @Column(name = "user_sex")
    private String sex;
    @Column(name = "user_eduction")
    private String eduction;
    @Column(name = "user_birthday")
    private Date birthday;
    @Column(name = "industry")
    private String industry;
    @Column(name = "profession")
    private String profession;
    @Column(name = "CreateDate")
    private Date CreateDate;
    @Column(name = "Pid")
    private int isDelete;
    @Column(name = "tel_number")
    private String telNumber;
    @OneToMany(mappedBy = "userInfo")
    private Set<Consult> consults =  new HashSet<Consult>();
    @OneToMany(mappedBy = "userInfo")
    private Set<SuggestCompl> compls = new HashSet<SuggestCompl>();
    @OneToMany(mappedBy ="userInfo")
    private Set<Appointment> appointments = new HashSet<>();

}
