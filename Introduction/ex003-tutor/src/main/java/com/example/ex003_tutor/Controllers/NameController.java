package com.example.ex003_tutor.Controllers;

import com.example.ex003_tutor.Services.ContrarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    @Autowired
    private ContrarioService contrarioService;


    @RequestMapping(value = "/{name}", method={RequestMethod.POST})
    public String nomeContrario(@PathVariable String name) {
        return contrarioService.contrarioVar(name);
    }

    @RequestMapping(value = "/{name}", method={RequestMethod.GET})
    public String nomeNormal(@PathVariable String name){
        return name;
    }
}
