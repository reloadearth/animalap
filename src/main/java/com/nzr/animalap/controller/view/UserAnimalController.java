package com.nzr.animalap.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AnimalList;
import com.nzr.animalap.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserAnimalController {

    private AnimalService animalService;

    @RequestMapping("/animal")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,9);
        List<AnimalList> animals = animalService.animalListV();
        if(animals != null){
            PageInfo<AnimalList> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
        }

        return "animals";
    }

    @PostMapping("/animal/search")
    public String search(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,9);
        List<AnimalList> animals = animalService.animalListV();
        if(animals != null){
            PageInfo<AnimalList> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
        }

        return "animals :: animalList";
    }

    @GetMapping("/animal/detail")
    public String detail(Model model,@RequestParam Integer id){
        Animal animal = animalService.getDetailById(id);
        if(animal != null){
            model.addAttribute("animal",animal);
        }
        return "animal_detail";
    }



}
