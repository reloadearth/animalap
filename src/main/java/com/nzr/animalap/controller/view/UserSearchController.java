package com.nzr.animalap.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.queryVo.AnimalList;
import com.nzr.animalap.queryVo.UserList;
import com.nzr.animalap.service.AnimalService;
import com.nzr.animalap.service.PostService;
import com.nzr.animalap.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserSearchController {

    private AnimalService animalService;
    private UserService userService;
    private PostService postService;

    @GetMapping("/search/animal")
    public String first(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                    @RequestParam(defaultValue = "",value = "keyword")String keyword){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,12,orderby);
        List<AnimalList> animals = animalService.rch(keyword);
        if(animals != null){
            PageInfo<AnimalList> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("key",keyword);
        }
        return "search_animal";
    }

    @PostMapping("/search/animal")
    public String f(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                    @RequestParam(defaultValue = "",value = "keyword")String keyword){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,12,orderby);
        List<AnimalList> animals = animalService.rch(keyword);
        if(animals != null){
            PageInfo<AnimalList> pageInfo = new PageInfo<>(animals);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("key",keyword);
        }
        return "search_animal :: searchList";
    }

    @GetMapping("/search/user")
    public String second(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                    @RequestParam(defaultValue = "",value = "keyword")String keyword){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,12,orderby);
            List<UserList> users = userService.rch(keyword);
        if(users != null){
            PageInfo<UserList> pageInfo = new PageInfo<>(users);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "search_user";
    }
    @PostMapping("/search/user")
    public String s(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                    @RequestParam(defaultValue = "",value = "keyword")String keyword){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,12,orderby);
            List<UserList> users = userService.rch(keyword);
        if(users != null){
            PageInfo<UserList> pageInfo = new PageInfo<>(users);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("key",keyword);
        }
        return "search_user :: searchList";
    }

    @GetMapping("/search/bbs")
    public String third(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                    @RequestParam(defaultValue = "",value = "keyword")String keyword){
        String orderby = "p.createtime desc";
        PageHelper.startPage(pageNum,12,orderby);
        List<Post> posts = postService.rch(keyword);
        if(posts != null){
            PageInfo<Post> pageInfo = new PageInfo<>(posts);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "search_bbs";
    }

    /**
     * 首次进入论坛
     * @param model
     * @param pageNum
     * @param session
     * @return
     */
    @GetMapping("/bbs")
    public String newPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,HttpSession session){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,12,orderby);
        List<Post> posts = postService.listByUserId(((User)session.getAttribute("user")).getId());
        if(posts != null){
            PageInfo<Post> pageInfo = new PageInfo<>(posts);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "post";
    }

    /**
     * 分页
     * @param model
     * @param pageNum
     * @param session
     * @return
     */
    @PostMapping("/bbs")
    public String toPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,HttpSession session){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,12,orderby);
        List<Post> posts = postService.listByUserId(((User)session.getAttribute("user")).getId());
        if(posts != null){
            PageInfo<Post> pageInfo = new PageInfo<>(posts);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "post :: searchList";
    }
}
