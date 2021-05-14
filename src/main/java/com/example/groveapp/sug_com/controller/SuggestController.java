package com.example.groveapp.sug_com.controller;

import com.example.groveapp.sug_com.entiry.SuggestCompl;
import com.example.groveapp.sug_com.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuggestController {
    @Autowired
    SuggestService service;

    @PostMapping("/suggest/save.do")
    public SuggestCompl save(@RequestBody SuggestCompl suggest){
        SuggestCompl save = service.save(suggest);
        return save;
    }

    @GetMapping("/suggest/find/{userCode}.json")
    public List<SuggestCompl> findAllByUserCode(@PathVariable String code){
        List<SuggestCompl> allByUserCode = service.findAllByUserCode(code);
        return allByUserCode;
    }
}
