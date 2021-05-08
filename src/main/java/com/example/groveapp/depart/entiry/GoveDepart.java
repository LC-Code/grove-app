package com.example.groveapp.depart.entiry;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "gove_part")
public class GoveDepart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "part_code")
    private String part_code;
    @Column(name = "part_name")
    private String part_name;
    @Column(name = "part_power")
    private String part_power;
    @Column(name = "part_level")
    private String part_level;
    @OneToMany(mappedBy = "depart")
    private Set<AppointmentItem> items;

}
