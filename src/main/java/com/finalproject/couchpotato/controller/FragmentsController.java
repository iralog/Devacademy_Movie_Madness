package com.finalproject.couchpotato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class FragmentsController {

    @GetMapping("/index")
    public String getHome() {
        return "index.html";
    }

    @GetMapping("/admin")
    public String getAdmin() {return "admin.html";}

    @GetMapping("/user")
    public String getUser() {return "user.html";}
}