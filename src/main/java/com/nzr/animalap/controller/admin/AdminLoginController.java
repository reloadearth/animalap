package com.nzr.animalap.controller.admin;

import com.nzr.animalap.pojo.User;
import com.nzr.animalap.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/fff")
@AllArgsConstructor
public class AdminLoginController {

    private UserService userService;

    @GetMapping
    public String ToLogin(){
        return "fff/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes attributes, HttpSession session){
        User admin = userService.adminLogin(username,password);
        if( admin != null){
            admin.setPassword(null);
            session.setAttribute("admin",admin);
            return "redirect:/fff/animal";
        }
        attributes.addFlashAttribute("message","账号或密码不正确");
        return "redirect:/fff";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        return "fff/login";
    }

}
