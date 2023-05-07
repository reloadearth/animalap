package com.nzr.animalap.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Post;
import com.nzr.animalap.pojo.PostReply;
import com.nzr.animalap.queryVo.PostDetail;
import com.nzr.animalap.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserPostController {

    private PostService postService;

    @GetMapping("/bbs/detail")
    public String detail(Model model, @RequestParam Integer id){
        PostDetail postDetail = postService.getById(id);
        if(postDetail != null){
            model.addAttribute("postDetail",postDetail);
            model.addAttribute("newReply",new PostReply());
        }
        return "post_detail";
    }

    @PostMapping("/bbs/newReply")
    public String newReply(RedirectAttributes redirectAttributes,PostReply postReply){
        int res = postService.newReply(postReply);
        if(res == 1){
            redirectAttributes.addFlashAttribute("评论发表成功！");
        }else{
            redirectAttributes.addFlashAttribute("评论发表失败!");
        }
        return "redirect:/view/bbs/detail?id="+postReply.getPostId();
    }

    @PostMapping("/search/bbs")
    public String ownPost(Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                    @RequestParam(defaultValue = "",value = "keyword")String keyword){
        String orderby = "p.createtime desc";
        PageHelper.startPage(pageNum,12,orderby);
        List<Post> posts = postService.rch(keyword);
        if(posts != null){
            PageInfo<Post> pageInfo = new PageInfo<>(posts);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("key",keyword);
        }
        return "search_bbs :: searchList";
    }

}
