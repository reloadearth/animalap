package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Animal;
import com.nzr.animalap.queryVo.AnimalQuery;
import com.nzr.animalap.service.AnimalCategoryService;
import com.nzr.animalap.service.AnimalService;
import com.nzr.animalap.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fff")
@AllArgsConstructor
public class AdminAnimalController {

    private AnimalService animalService;
    private AnimalCategoryService categoryService;
    private UserService userService;

    @RequestMapping("/animal")
    public String listAnimals(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,10,orderby);

        List<AnimalQuery> animals = animalService.animalList();
        if(animals != null){
            PageInfo<AnimalQuery> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
        }else{
            return "error/404";
        }

        return "fff/animal";
    }

    @PostMapping("/animal/search")
    public String search(@RequestParam String keyword,Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,10,orderby);

        List<AnimalQuery> animals = animalService.search(keyword);
        if(animals != null){
            PageInfo<AnimalQuery> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
        }

        return "fff/animal :: animalList";
    }

    @GetMapping("/animal/input")
    public String ToInput(Model model){
        Animal demo = new Animal();
        demo.setGrade(3);
        model.addAttribute("animal",demo);
        model.addAttribute("animalCategorys",categoryService.animalCategoryList());
        model.addAttribute("users",userService.nicknameList());
        return "fff/animal_input";
    }

    @PostMapping("/animal/input")
    public String input(Animal animal, RedirectAttributes attributes){
        int res = animalService.add(animal);
        if(res == 1){
            attributes.addFlashAttribute("message","添加成功");
        }else{
            attributes.addFlashAttribute("message","添加失败");
        }
        return "redirect:/fff/animal";
    }

    @GetMapping("/animal/{id}/remove")
    public String remove(@PathVariable int id,RedirectAttributes attributes){
        int res = animalService.remove(id);
        if(res == 1){
            attributes.addFlashAttribute("message","删除成功");
        }else{
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/fff/animal";
    }

    @GetMapping("/animal/{id}/input")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("animal",animalService.getById(id));
        model.addAttribute("animalCategorys",categoryService.animalCategoryList());
        model.addAttribute("users",userService.nicknameList());
        return "fff/animal_input";
    }

    @PostMapping("/animal/{id}/input")
    public String edit(Animal animal,RedirectAttributes attributes){
        int res = animalService.edit(animal);
        if(res == 1){
            attributes.addFlashAttribute("message","更新成功");
        }else{
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/fff/animal";
    }
}
