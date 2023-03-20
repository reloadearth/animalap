package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Avatar;
import com.nzr.animalap.service.AvatarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fff")
@AllArgsConstructor
public class AdminAvatarController {

    private AvatarService avatarService;

    @RequestMapping("/avatar")
    public String avatarList(Model model, @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Avatar> avatars = avatarService.list();
        if(avatars != null){
            PageInfo<Avatar> pageInfo = new PageInfo<>(avatars);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/avatar";
    }

    @PostMapping("/avatar/search")
    public String search(@RequestParam String keyword,Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Avatar> avatars = avatarService.search(keyword);
        if(avatars != null){
            PageInfo<Avatar> pageInfo = new PageInfo<>(avatars);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/avatar :: avatarList";
    }

    @GetMapping("/avatar/input")
    public String ToInput(Model model){
        Avatar avatar = new Avatar();
        avatar.setFlag(true);
        model.addAttribute("avatar",avatar);
        return "fff/avatar_input";
    }

    @PostMapping("/avatar/input")
    public String input(Avatar avatar, RedirectAttributes attributes){
        int res = avatarService.add(avatar);
        if(res == 1){
            attributes.addFlashAttribute("message","添加成功");
        }else{
            attributes.addFlashAttribute("message","添加失败");
        }
        return "redirect:/fff/avatar";
    }

    @GetMapping("/avatar/{id}/remove")
    public String remove(@PathVariable int id, RedirectAttributes attributes){
        int res = avatarService.remove(id);
        return "redirect:/fff/avatar";
    }

    @GetMapping("/avatar/{id}/input")
    public String ToEdit(@PathVariable int id,Model model){
        model.addAttribute("avatar",avatarService.getById(id));
        return "fff/avatar_input";
    }

    @PostMapping("/avatar/{id}/input")
    public String Edit(Avatar avatar,RedirectAttributes attributes){
        int res = avatarService.edit(avatar);
        if(res == 1){
            attributes.addFlashAttribute("message","编辑成功");
        }else{
            attributes.addFlashAttribute("message","编辑失败");
        }
        return "redirect:/fff/avatar";
    }
}
