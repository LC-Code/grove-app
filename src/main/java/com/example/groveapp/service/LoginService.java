package com.example.groveapp.service;

import com.example.groveapp.entiry.WxLoginRespond;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService {
    WxLoginRespond getSeesionKeyAndOpenId(String code) throws JsonProcessingException;
}
