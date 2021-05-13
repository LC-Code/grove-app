package com.example.groveapp.entiry;

import com.example.groveapp.appointment.entiry.Appointment;
import com.example.groveapp.sug_com.entiry.Consult;
import com.example.groveapp.sug_com.entiry.SuggestCompl;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user_info")
public class UserInfo implements Serializable {
    public interface WxRequestBody{}

    @Id
    @Column(name = "user_code")
    private String code;
    @Column(name = "user_name")
    private String name;
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "id_type")
    @JsonIgnore
    private String idType;

    @Column(name = "id_cord")
    private String idCode;
    @Column(name = "user_sex")
    private String sex;
    @Column(name = "user_eduction")
    private String education;
    @Column(name = "user_birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(name = "industry")
    private String industry;
    @Column(name = "profession")
    private String profession;
    @Column(name = "create_date")
    @JsonIgnore
    private Date CreateDate;
    @Column(name = "Pid")
    @JsonIgnore
    private int isDelete;
    @Column(name = "tel_number")
    @JsonProperty("telphone")
    private String telNumber;

    @OneToMany(mappedBy = "userInfo",cascade = CascadeType.ALL)
    private Set<Consult> consults =  new HashSet<Consult>();

    @OneToMany(mappedBy = "userInfo",cascade = CascadeType.ALL)
    private Set<SuggestCompl> compls = new HashSet<SuggestCompl>();

    @OneToMany(mappedBy ="userInfo", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

}
