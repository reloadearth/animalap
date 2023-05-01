package com.nzr.animalap.controller.view;

import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.service.AgreementService;
import com.nzr.animalap.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/view")
@AllArgsConstructor
public class UserAgreementController {

    private AgreementService agreementService;
    private AnimalService animalService;

    @GetMapping("/animal/adopt")
    public String index(@RequestParam int id, Model model){
        model.addAttribute("animal",animalService.getDetailById(id));
        Agreement agreement = new Agreement();
        agreement.setCreatetime(new Date());
        agreement.setUpdatetime(new Date());
        model.addAttribute("agreement",agreement);
        return "agreement";
    }

    @PostMapping("/animal/agreement")
    public String submit(Agreement agreement, RedirectAttributes redirectAttributes){
        int res = agreementService.add(agreement);
        if(res == 1){
            redirectAttributes.addFlashAttribute("message","申请成功");
        }else{
            redirectAttributes.addFlashAttribute("message","申请失败");
        }
        return "redirect:/view/user/agreement";
    }
}
