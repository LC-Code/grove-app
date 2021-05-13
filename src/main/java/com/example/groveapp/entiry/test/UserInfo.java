package com.example.groveapp.entiry.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Date;
@Data
@JsonIgnoreProperties({"id","code","password","idType","idCode",})
public class UserInfo {
    public interface WxRequestBody{}

    private int id;

    private String code;
@JsonView(WxRequestBody.class)
    private String name;

    private String password;

    private String idType;

    private String idCode;
    @JsonView(WxRequestBody.class)
    private String sex;
    @JsonView(WxRequestBody.class)
    private String education;
    @JsonView(WxRequestBody.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @JsonView(WxRequestBody.class)
    private String industry;
    @JsonView(WxRequestBody.class)
    private String profession;
    @JsonView(WxRequestBody.class)
    private String telphone;

}
