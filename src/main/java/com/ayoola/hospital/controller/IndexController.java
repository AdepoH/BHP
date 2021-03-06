package com.ayoola.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model){

        return "/index";
    }

    @GetMapping("/doctor")
    public String doctor(Model model){
        return "/doctor";
    }


    @GetMapping("/reception")
    public String reception(Model model){
        return "/reception";
    }

    @GetMapping("/patients")
    public String test(Model model){

        return "/test";
    }



}
