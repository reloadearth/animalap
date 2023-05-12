package com.nzr.animalap.controller.view;

import com.nzr.animalap.pojo.User;
import com.nzr.animalap.pojo.Vcode;
import com.nzr.animalap.service.UserService;
import com.nzr.animalap.utils.SendEmailUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserLoginController {

    private UserService userService;

    @GetMapping("/login")
    public String tologin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        User user = userService.checkUsernameAndPassword(username,password);
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/view/home";
        }
        attributes.addFlashAttribute("message","账号或密码有误，请重新输入");
        return "redirect:/view/login";
    }

    @GetMapping("/signup")
    public String toSignup(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user,RedirectAttributes attributes){
        int res = userService.signup(user);
        if(res == 1){
            attributes.addFlashAttribute("message","注册成功");
            return "login";
        }
        attributes.addFlashAttribute("message","注册失败，可能是邮箱已被注册或（邮箱/密码）格式有误");
        return "redirect:/view/signup";
    }

    @PostMapping("/checkrepeat")
    @ResponseBody
    public boolean checkrepeat(@RequestParam String username){
        User res = userService.checkrepeat(username);
        if(res != null) {
            return false;
        }
        return true;
    }

    @GetMapping("/forgot")
    public String toForgot(Model model){
        model.addAttribute("username",new User());
        return "forgot";
    }

    @GetMapping("/vcode")
    @ResponseBody
    public int vcode(@RequestParam String username){
        try {
            String newVcode = getvcode();
            SendEmailUtils.sendEmail(username,newVcode);
            Vcode vcode = new Vcode();
            vcode.setVcode(newVcode);
            vcode.setUserId(userService.getByUsername(username).getId());
            userService.setVcode(vcode);
            return 1;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getvcode(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++){
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }

    @PostMapping("/forgot")
    public String forgot(@RequestParam String username,@RequestParam String vcode,@RequestParam String password,RedirectAttributes attributes){
        int res = userService.forgot(username,vcode,password);
        switch (res){
            case 11: attributes.addFlashAttribute("message","验证码已失效");
                    return "redirect:/view/forgot";
            case 22: attributes.addFlashAttribute("message","验证码有误，请仔细检查");
                    return "redirect:/view/forgot";
            case 33: attributes.addFlashAttribute("message","不能改为原密码!");
                    return "redirect:/view/forgot";
            case 1: attributes.addFlashAttribute("message","重置密码成功");
                    return "redirect:/view/login";
            default: attributes.addFlashAttribute("message","密码/验证码格式有误");
                    return "redirect:/view/forgot";
        }
    }
    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/view/login";
    }
}
