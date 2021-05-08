package com.example.groveapp.appointment.entiry;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "marriage_registration")
public class MarriageReg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "register_code")
    private String code;
    @Column(name = "register_type")
    private String type;
    @Column(name = "register_part")
    private String part;
    @Column(name = "register_human")
    private String human;
    @Column(name = "man_code")
    private String man_code;
    @Column(name = "woman_code")
    private String woman_code;


}
