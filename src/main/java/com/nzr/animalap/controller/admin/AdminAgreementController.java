package com.nzr.animalap.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.queryVo.AgreementQuery;
import com.nzr.animalap.service.AgreementService;
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
@RequestMapping("/fff")
@AllArgsConstructor
public class AdminAgreementController {

    private AgreementService agreementService;

    @RequestMapping("/rop")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<AgreementQuery> agreements = agreementService.list();
        if(agreements != null){
            PageInfo<AgreementQuery> pageInfo = new PageInfo<>(agreements);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/agreement";
    }

    @PostMapping("/rop/search")
    public String search(Model model,@RequestParam String keyword,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        String orderby = "updatetime desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<AgreementQuery> agreements = agreementService.search(keyword);
        if(agreements != null){
            PageInfo<AgreementQuery> pageInfo = new PageInfo<>(agreements);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "fff/agreement :: agreementList";
    }

    @GetMapping("/rop/edit")
    public String ToEdit(Model model,Integer id){
        Agreement agreement = agreementService.getById(id);
        model.addAttribute("agreement",agreement);
        return "fff/agreement_edit";
    }

    @PostMapping("/rop/edit")
    public String edit(Agreement agreement, RedirectAttributes attributes){
        int res = agreementService.edit(agreement);
        if(res == 1){
            attributes.addFlashAttribute("message","编辑成功");
        }else{
            attributes.addFlashAttribute("message","编辑失败");
        }
        return "redirect:/fff/rop";
    }
}
