package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.PostReply;
import com.nzr.animalap.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fff")
@AllArgsConstructor
public class AdminPostController {

    private PostService postService;

    @RequestMapping("/bbs")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Post> posts = postService.list();
        if(posts != null){
            PageInfo<Post> pageInfo = new PageInfo<>(posts);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/post";
    }

    @PostMapping("/bbs/search")
    public String search(Model model,@RequestParam String keyword, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Post> posts = postService.search(keyword);
        if(posts != null){
            PageInfo<Post> pageInfo = new PageInfo<>(posts);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/post :: postList";
    }

    @GetMapping("/bbs/{id}/banned")
    public String banned(@PathVariable Integer id, RedirectAttributes attributes){
        int res = postService.banned(id);
        if(res == 1){
            attributes.addFlashAttribute("message","成功封禁");
        }else{
            attributes.addFlashAttribute("message","封禁失败");
        }
        return "redirect:/fff/bbs";
    }

    @GetMapping("/bbs/{id}/unblock")
    public String unblock(@PathVariable Integer id, RedirectAttributes attributes){
        int res = postService.unblock(id);
        if(res == 1){
            attributes.addFlashAttribute("message","成功解封");
        }else{
            attributes.addFlashAttribute("message","解封失败");
        }
        return "redirect:/fff/bbs";
    }

    @RequestMapping("/bbs2")
    public String index2(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<PostReply> postReplies = postService.list2();
        if(postReplies != null){
            PageInfo<PostReply> pageInfo = new PageInfo<>(postReplies);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/post_reply";
    }

    @PostMapping("/bbs2/search")
    public String search2(Model model,@RequestParam String keyword,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<PostReply> postReplies = postService.search2(keyword);
        if(postReplies != null){
            PageInfo<PostReply> pageInfo = new PageInfo<>(postReplies);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/post_reply :: replyList";
    }

    @GetMapping("/bbs2/{id}/banned")
    public String banned2(@PathVariable Integer id,RedirectAttributes attributes){
        int res = postService.banned2(id);
        if(res == 1){
            attributes.addFlashAttribute("message","封禁成功");
        }else{
            attributes.addFlashAttribute("message","封禁失败");
        }
        return "redirect:/fff/bbs2";
    }

    @GetMapping("/bbs2/{id}/unblock")
    public String unblock2(@PathVariable Integer id,RedirectAttributes attributes){
        int res = postService.unblock2(id);
        if(res == 1){
            attributes.addFlashAttribute("message","解封成功");
        }else{
            attributes.addFlashAttribute("message","解封失败");
        }
        return "redirect:/fff/bbs2";
    }
}
