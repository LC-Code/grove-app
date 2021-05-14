package com.example.groveapp.depart.entiry;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gove_part")
public class GoveDepart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "part_code")
    private String partCode;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "part_power")
    private String partPower;

    @Column(name = "part_level")
    private String partLevel;


}
