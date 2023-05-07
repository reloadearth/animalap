package com.nzr.animalap.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Opinion;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.queryVo.AnimalList;
import com.nzr.animalap.service.AnimalService;
import com.nzr.animalap.service.AvatarService;
import com.nzr.animalap.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserHomeController {

    private AnimalService animalService;

    private UserService userService;
    private AvatarService avatarService;

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

    @GetMapping("/user/home")
    public String userInfo(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        model.addAttribute("currentAvatar",avatarService.getById(user.getAvatarId()));
        model.addAttribute("avatars",avatarService.list());
        Opinion opinion = userService.getOpinionByUserId(user.getId());
        if(opinion == null){
            opinion = new Opinion();
            opinion.setContent("无");
        }
        model.addAttribute("opinion",opinion);
        return "user_info";
    }

    @GetMapping("/user/home/edit")
    public String edit(HttpSession session,String nickname, String opinion, Integer avatarId, RedirectAttributes redirectAttributes){
        User user = (User)session.getAttribute("user");
        user.setNickname(nickname);
        user.setAvatarId(avatarId);
        int res = userService.userEdit(user,opinion);
        if(res == 1){
            redirectAttributes.addFlashAttribute("message","编辑成功");
        }else{
            redirectAttributes.addFlashAttribute("message","一个星期只能修改一次哦");
        }
        return "redirect:/view/user/home";
    }


}
