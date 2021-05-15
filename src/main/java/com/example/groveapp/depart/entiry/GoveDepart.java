package com.example.groveapp.depart.entiry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "gove_part")
public class GoveDepart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @Column(name = "part_code")
    private String partCode;

    @Column(name = "part_name")
    private String partName;
    @JsonIgnore
    @Column(name = "part_power")
    private String partPower;
    @JsonIgnore
    @Column(name = "part_level")
    private String partLevel;


}
