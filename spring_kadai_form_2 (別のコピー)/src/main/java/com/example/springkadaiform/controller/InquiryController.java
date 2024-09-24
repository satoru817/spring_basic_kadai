package com.example.springkadaiform.controller;

import com.example.springkadaiform.entity.Inquiry;
import com.example.springkadaiform.service.InquiryService;
import jakarta.transaction.Transactional;
import org.springframework.core.Conventions;
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

    public InquiryController(InquiryService inquiryService){
        this.inquiryService = inquiryService;
    }

    @GetMapping("/form")
    public String form(Model model){
        if(!model.containsAttribute("inquiry")){
            Inquiry inquiry = new Inquiry();
            model.addAttribute("inquiry",inquiry);
        }

        return "inquiryForm";
    }

    @PostMapping("/confirm")
    public String confirm(Model model,
                          @ModelAttribute @Validated Inquiry inquiry,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if(!bindingResult.hasErrors()){
            model.addAttribute("inquiry",inquiry);
            return "confirmView";
        }else{
            redirectAttributes.addFlashAttribute("inquiry",inquiry);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
            + Conventions.getVariableName(inquiry),bindingResult);

            return "redirect:/form";
        }
    }

    @PostMapping("/showAll")
    public String showAll_p(Model model,
                            @ModelAttribute Inquiry inquiry){
        inquiryService.save(inquiry);
        getAllInquiryAndAddThemToModel(model);
        return "showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        getAllInquiryAndAddThemToModel(model);
        return "showAll";
    }

    public void getAllInquiryAndAddThemToModel( Model model){

        List<Inquiry> inquiryList = inquiryService.fetchAll();
        model.addAttribute("inquiryList",inquiryList);
    }
}
