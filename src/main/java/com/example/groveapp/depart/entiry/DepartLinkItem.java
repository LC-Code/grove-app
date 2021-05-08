/*
package com.example.groveapp.depart.entiry;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "depart_item")
public class DepartLinkItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "depart_code")
    private GoveDepart depart;
    @ManyToOne
    @JoinColumn(name = "item_code")
    private AppointmentItem item;
}
*/
