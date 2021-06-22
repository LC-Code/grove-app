package com.example.groveapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

@EnableCaching
@SpringBootApplication
public class GroveAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroveAppApplication.class, args);
    }
}
