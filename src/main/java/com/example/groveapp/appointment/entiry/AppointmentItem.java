package com.example.groveapp.appointment.entiry;

import com.example.groveapp.depart.entiry.GoveDepart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "appointment_item")
public class AppointmentItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;
    @JsonIgnore
    @Column(name = "dispose_type")
    private String disposeType;
    @JsonIgnore
    @Column(name = "part_code")
    private String partCode;

}
