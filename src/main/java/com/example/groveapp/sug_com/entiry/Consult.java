package com.example.groveapp.sug_com.entiry;

import com.example.groveapp.entiry.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "consult")
public class Consult implements Serializable {
    @Id
    @GenericGenerator(name = "consult_uuid",strategy = "uuid")
    @GeneratedValue(generator = "consult_uuid")
    @Column(name = "consult_code")
    private String consultCode;

    @Column(name = "consult_part")
    private String consultPart;

    @Column(name = "consult_theme")
    private String consultTheme;

    @Column(name = "consult_content")
    private String consultContent;

    @Column(name = "is_callback")
    private String isCallback;

    @Column(name = "callback_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date callbackTime;

    @Column(name = "user_code")
    private String userCode;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date CreatDate;
}
