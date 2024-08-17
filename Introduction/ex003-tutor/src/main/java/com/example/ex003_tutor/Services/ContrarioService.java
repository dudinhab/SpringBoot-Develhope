package com.example.ex003_tutor.Services;

import org.springframework.stereotype.Service;

@Service
public class ContrarioService {

    public String contrarioVar(String name){
        return new StringBuilder(name).reverse().toString();
    }
}
