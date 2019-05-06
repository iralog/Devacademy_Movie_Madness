package com.finalproject.couchpotato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = {"/user"})
    public String user() {
        return "user";
    }

    @RequestMapping(value = {"login"})
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"403"})
    public String Error403() {
        return "403";
    }
}

