package com.example.groveapp.appointment.entiry;

import com.example.groveapp.depart.entiry.GoveDepart;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appointment_item")
public class AppointmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "item_code")
    private String code;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "dispose_type")
    private String disposeType;
   @ManyToOne
   @JoinColumn(name = "part_code")
    private GoveDepart depart;
}
