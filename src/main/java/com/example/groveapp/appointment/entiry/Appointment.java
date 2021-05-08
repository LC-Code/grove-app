package com.example.groveapp.appointment.entiry;

import com.example.groveapp.entiry.UserInfo;
import lombok.CustomLog;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "app_code")
    private String appCode;
    @OneToOne
    @JoinColumn(name = "item_code")
    private AppointmentItem item;
    private Date app_time;
    private Date accept_time;
    private String is_accept;
    private String no_accept_info;
    private String evaluate;
    @ManyToOne
    @JoinColumn(name = "user_code")
    private UserInfo userInfo;
}
