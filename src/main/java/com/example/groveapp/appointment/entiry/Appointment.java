package com.example.groveapp.appointment.entiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "appointment")
public class Appointment implements Serializable {
    @Id
    @GenericGenerator(name = "app_code_uuid",strategy = "uuid")
    @GeneratedValue(generator = "app_code_uuid")
    @Column(name = "app_code")
    private String appCode;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "app_time_am")
    private String appTimeAm;

    @Column(name = "app_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appTime;

    @Column(name = "is_accept")
    //1 or 0
    private String isAccept;

    @Column(name = "evaluate")
    private String evaluate;

    @Column(name = "accept_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date acceptTime;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Column(name = "user_code")
    private String userCode;


}
