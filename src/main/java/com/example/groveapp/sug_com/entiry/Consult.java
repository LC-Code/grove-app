package com.example.groveapp.sug_com.entiry;

import com.example.groveapp.entiry.UserInfo;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "consult")
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String consult_code;
    private String consult_part;
    private String consult_theme;
    private String consult_content;
    private String is_callback;
    private Date callback_time;
    @ManyToOne
    @JoinColumn(name="user_code")
    private UserInfo userInfo;
}
