package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Avatar;
import com.nzr.animalap.service.AvatarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
