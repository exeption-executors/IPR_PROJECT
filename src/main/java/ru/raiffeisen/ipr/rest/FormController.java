package ru.raiffeisen.ipr.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {


    @RequestMapping("/success")
    public String success() {
        return "success.html";
    }
}
