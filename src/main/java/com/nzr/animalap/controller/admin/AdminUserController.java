package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.queryVo.UserDetailQuery;
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
public class AdminUserController {

    private UserService userService;

    @RequestMapping("/user")
    public String listUsers(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<UserDetailQuery> users = userService.detailList();
        if(users != null){
            PageInfo<UserDetailQuery> pageInfo = new PageInfo(users);
            model.addAttribute("pageInfo",pageInfo);
        }else{
            return "error/404";
        }
        return "fff/user";
    }

    @PostMapping("/user/search")
    public String search(@RequestParam String keyword,Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<UserDetailQuery> users = userService.search(keyword);
        if(users != null){
            PageInfo<UserDetailQuery> pageInfo = new PageInfo<>(users);
            model.addAttribute("pageInfo",pageInfo);
        }else{
            return "error/404";
        }
        return "fff/user :: userList";
    }

    @GetMapping("/user/input")
    public String ToInput(Model model){
        User user = new User();
        user.setFlag(0);
        user.setStatus(true);
        model.addAttribute("user",user);
        return "fff/user_input";
    }

    @PostMapping("/user/input")
    public String input(User user, RedirectAttributes redirectAttributes){
        int res = userService.add(user);
        if(res == 1){
            redirectAttributes.addFlashAttribute("message","添加成功");
        }else{
            redirectAttributes.addFlashAttribute("message","添加失败,邮箱已被注册");
        }
        return "redirect:/fff/user";
    }

    @GetMapping("/user/{id}/remove")
    public String remove(@PathVariable int id,RedirectAttributes attributes){
        int res = userService.remove(id);
        if(res == 1){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/fff/user";
    }

    @GetMapping("/user/{id}/input")
    public String ToEdit(@PathVariable int id,Model model){
        model.addAttribute("user",userService.getById(id));
        return "fff/user_input";
    }

    @PostMapping("/user/{id}/input")
    public String edit(User user,RedirectAttributes attributes){
        int res = userService.edit(user);
        if(res == 1){
            attributes.addFlashAttribute("message","编辑成功");
        }else{
            attributes.addFlashAttribute("message","编辑失败");
        }
        return "redirect:/fff/user";
    }
}
