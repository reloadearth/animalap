package com.nzr.animalap.controller.view;

import com.nzr.animalap.pojo.Agreement;
import com.nzr.animalap.pojo.User;
import com.nzr.animalap.queryVo.AgreementQuery;
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

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
        }else if(res == 3){
            redirectAttributes.addFlashAttribute("message","1个申请流程进行中，不能继续申请");
        }else{
            redirectAttributes.addFlashAttribute("message","申请失败");
        }
        return "redirect:/view/user/agreement";
    }

    @GetMapping("/user/agreement")
    public String show(Model model, HttpSession session) throws Exception {
        List<AgreementQuery> agreements = agreementService.listByUserId(((User)(session.getAttribute("user"))).getId());
        System.err.println(agreements);
        if(agreements != null){
            model.addAttribute("agreements",agreements);
            return "agreement_flow";
        }else {
            throw new Exception("服务器异常");
        }
    }

    @GetMapping("/user/agreement/withdraw")
    public String withdraw(RedirectAttributes redirectAttributes,@RequestParam Integer id){
        int res = agreementService.withdraw(id);
        if(res == 1){
            redirectAttributes.addFlashAttribute("message","撤回申请成功！");
        }else{
            redirectAttributes.addFlashAttribute("message","撤回申请失败！");
        }
        return "redirect:/view/user/agreement";
    }
}
