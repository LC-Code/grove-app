package com.example.groveapp.appointment.entiry;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "register_peoper_info")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "per_code")
    private String per_code;
    @Column(name = "per_name")
    private String per_name;
    @Column(name = "id_type")
    private String id_type;
    @Column(name = "id_code")
    private String id_code;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "eare")
    private String eare;
    @Column(name = "marriage_status")
    private String marriage_status;
    @Column(name = "tel_number")
    private String tel_number;

}
