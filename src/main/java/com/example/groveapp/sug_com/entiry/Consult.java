package com.example.groveapp.sug_com.entiry;

import com.example.groveapp.entiry.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "consult")
public class Consult {
    @Id
    @GenericGenerator(name = "consult_uuid",strategy = "uuid")
    @GeneratedValue(generator = "consult_uuid")
    @Column(name = "consult_code")
    private String consult_code;

    @Column(name = "consult_part")
    private String consult_part;

    @Column(name = "consult_theme")
    private String consult_theme;

    @Column(name = "consult_content")
    private String consult_content;

    @Column(name = "is_callback")
    private String is_callback;

    @Column(name = "callback_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date callback_time;

    @Column(name = "user_code")
    private String userCode;

    @Column(name = "CreateDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatdate;
}
