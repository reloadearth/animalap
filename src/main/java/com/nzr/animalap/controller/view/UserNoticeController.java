package com.nzr.animalap.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Notice;
import com.nzr.animalap.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/view")
public class UserNoticeController {

    private NoticeService noticeService;

    @GetMapping("/notice")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum) {
        String orderby = "createtime desc";
        PageHelper.startPage(pageNum,5,orderby);
        List<Notice> notices = noticeService.list1();
        if(notices != null){
            PageInfo<Notice> pageInfo = new PageInfo<>(notices);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "notice";
    }

}
