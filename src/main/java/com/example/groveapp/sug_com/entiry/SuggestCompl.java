package com.example.groveapp.sug_com.entiry;

import com.example.groveapp.entiry.UserInfo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "suggest_complaints")
public class SuggestCompl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String item_name;
    private String item_code;
    private String sug_cm;
    private String part_name;
    private String title;
    private String context;
    private String callback;
    @ManyToOne
    @JoinColumn(name="user_code")
    private UserInfo userInfo;

}
