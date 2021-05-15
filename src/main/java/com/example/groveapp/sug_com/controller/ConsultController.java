package com.example.groveapp.sug_com.controller;

import com.example.groveapp.sug_com.entiry.Consult;
import com.example.groveapp.sug_com.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultController {

    @Autowired
    ConsultService service;

    @GetMapping("/consult/find/{userCode}.json")
    public List<Consult> findAllByUserCode(@PathVariable String userCode){
        List<Consult> allByUserCode = service.findAllByUserCode(userCode);
        return allByUserCode;
    }

    @PostMapping("/consult/save.do")
    public Consult save(@RequestBody Consult consult){
        Consult saveConsul = service.saveConsul(consult);
        return saveConsul;
    }

    @GetMapping(path = "/consult/find/simple/{code}.json")
    public List<Object> findSimple(@PathVariable String code){
        List<Object> simpleListByUserCode = service.findSimpleListByUserCode(code);
        return simpleListByUserCode;
    }
}
