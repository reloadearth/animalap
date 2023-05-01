package com.nzr.animalap.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.queryVo.AnimalList;
import com.nzr.animalap.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserHomeController {

    private AnimalService animalService;

    @RequestMapping("/home")
    public String ToHome(Model model){
//        String orderby = "updatetime desc";
        PageHelper.startPage(1,3);
        List<AnimalList> animals = animalService.animalListV();
        if(animals != null){
            PageInfo<AnimalList> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "home";
    }


}
