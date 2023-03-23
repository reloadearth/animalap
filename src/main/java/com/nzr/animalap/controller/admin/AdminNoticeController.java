package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Notice;
import com.nzr.animalap.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/fff")
@AllArgsConstructor
public class AdminNoticeController {

    private NoticeService noticeService;

    @RequestMapping("/notice")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Notice> notices = noticeService.list();
        if(notices != null){
            PageInfo<Notice> pageInfo = new PageInfo<>(notices);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/notice";
    }

    @PostMapping("/notice/search")
    public String search(Model model,@RequestParam String keyword,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Notice> notices = noticeService.search(keyword);
        if(notices != null){
            PageInfo<Notice> pageInfo = new PageInfo<>(notices);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/notice :: msgList";
    }

    @GetMapping("/notice/input")
    public String toInput(Model model){
        Notice notice = new Notice();
        notice.setFlag(true);
        model.addAttribute("notice",notice);
        return "fff/notice_input";
    }

    @PostMapping("/notice/input")
    public String input(Notice notice, RedirectAttributes attributes){
        System.out.println(notice);
        int res = noticeService.add(notice);
        if(res == 1){
            attributes.addFlashAttribute("message","添加成功");
        }else{
            attributes.addFlashAttribute("message","添加失败");
        }
        return "redirect:/fff/notice";
    }

    @GetMapping("/notice/{id}/remove")
    public String remove(@PathVariable Integer id,RedirectAttributes attributes){
        int res = noticeService.remove(id);
        if(res == 1){
            attributes.addFlashAttribute("message","删除成功");
        }else{
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/fff/notice";
    }

    @GetMapping("/notice/{id}/input")
    public String toEdit(Model model,@PathVariable Integer id){
        model.addAttribute("notice",noticeService.getById(id));
        return "fff/notice_input";
    }

    @PostMapping("/notice/{id}/input")
    public String edit(Notice notice, RedirectAttributes attributes){
        int res = noticeService.edit(notice);
        if(res == 1){
            attributes.addFlashAttribute("message","编辑成功");
        }else{
            attributes.addFlashAttribute("message","编辑失败");
        }
        return "redirect:/fff/notice";
    }

}
