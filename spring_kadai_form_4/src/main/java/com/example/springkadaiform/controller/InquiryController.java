package com.example.springkadaiform.controller;

import com.example.springkadaiform.entity.Inquiry;
import com.example.springkadaiform.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InquiryController {
    private InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/form")
    public String form(Model model) {
        if(!model.containsAttribute("inq")){
            Inquiry inq = new Inquiry();
            model.addAttribute("inq", inq);
        }

        return "inquiryForm";
    }

    @PostMapping("/confirm")
    public String confirm(Model model,
                          @ModelAttribute @Validated Inquiry inq,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if(!bindingResult.hasErrors()){
            model.addAttribute("inq",inq);
            return "confirmView";
        }else{
            redirectAttributes.addFlashAttribute("inq",inq);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
            +"inq",bindingResult);

            return "redirect:/form";
        }

    }

    @PostMapping("/register")
    public String register(Model model,
                           Inquiry inq){
        inquiryService.save(inq);
        return showAll(model);
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        fetchAllAndAddThemToTheModel(model);
        return "showAllInquiry";
    }

    public void fetchAllAndAddThemToTheModel(Model model){
        List<Inquiry> inqList = inquiryService.fetchAll();;
        model.addAttribute("inqList",inqList);
    }
}