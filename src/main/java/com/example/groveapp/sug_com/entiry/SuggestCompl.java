package com.example.groveapp.sug_com.entiry;

import com.example.groveapp.entiry.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "suggest_complaints")
public class SuggestCompl {
    @Id
    @GenericGenerator(name = "sug_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sug_uuid")
    @Column(name = "sug_com_code")
    private String sugComCode;
    private String itemCide;
    private String itemName;
    private String sugCom;
    private String partName;
    private String title;
    private String context;
    private String callback;
    private String userCode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

}
