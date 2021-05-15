package com.example.groveapp.sug_com.entiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "suggest_complaints")
public class SuggestCompl implements Serializable {
    @Id
    @GenericGenerator(name = "sug_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sug_uuid")
    @Column(name = "sug_com_code")
    private String sugComCode;
    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "item_name")
    private String itemName;
    @JsonIgnore
    @Column(name = "sug_com")
    private String sugCom;
    @Column(name = "part_name")
    private String partName;
    @Column(name = "title")
    private String title;
    @Column(name = "context")
    private String context;
    @Column(name = "callback")
    private String callback;
    @Column(name = "user_code")
    private String userCode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date")
    private Date CreateDate;

}
