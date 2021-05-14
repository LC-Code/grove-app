package com.example.groveapp.appointment.entiry;

import com.example.groveapp.entiry.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "appointment")
public class Appointment {
    public interface FindAppointmentForList{} //查询Json

    @Id
    @GenericGenerator(name = "code_uuid",strategy = "uuid")
    @GeneratedValue(generator = "code_uuid")
    @Column(name = "app_code")
    @JsonView(FindAppointmentForList.class)
    private String appCode;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "item_code")
    @JsonView({FindAppointmentForList.class,})
    private AppointmentItem item;

    @Column(name = "app_time_am")
    private String app_time_am;

    @Column(name = "app_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonView(FindAppointmentForList.class)
    private Date app_time;

    @Column(name ="accept_time")
    @JsonView(FindAppointmentForList.class)
    private Date accept_time;

    @JsonView(FindAppointmentForList.class)
    @Column(name = "is_accept")
    private String is_accept;

    @JsonView(FindAppointmentForList.class)
    @Column(name = "no_accept_info")
    private String no_accept_info;
    @Column(name = "evaluate")
    private String evaluate;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonView(FindAppointmentForList.class)
    private Date CreateDate;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_code")
    private UserInfo userInfo;

}
