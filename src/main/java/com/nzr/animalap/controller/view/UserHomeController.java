package com.nzr.animalap.controller.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/home")
@AllArgsConstructor
public class UserHomeController {

    @RequestMapping
    public String ToHome(){
        return "homepage";
    }

    @GetMapping
    public String ToBbs(){
        return "";
    }
}
