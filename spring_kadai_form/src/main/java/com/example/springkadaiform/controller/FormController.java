package com.example.springkadaiform.controller;

import com.example.springkadaiform.entity.Form;
import com.example.springkadaiform.service.FormService;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FormController {
    private FormService formService;

    public FormController(FormService formService){
        this.formService = formService;
    }

    @GetMapping("/form")
    public String inquiryForm(Model model){
        if(!model.containsAttribute("form")){
            Form form = new Form();
            model.addAttribute("form",form);
        }


        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(Model model,
                          @Validated Form form,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if(!bindingResult.hasErrors()){
            model.addAttribute("form",form);

            return "confirmView";
        }else{
            redirectAttributes.addFlashAttribute("form",form);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+
                    Conventions.getVariableName(form),bindingResult);

            return "redirect:/form";

        }
    }

    @GetMapping("/confirm")
    public String confirm(){
        return "confirmView";
    }

    @GetMapping("/allInquiry")
    public String allInquiry(Model model){
        List<Form> forms =  formService.fetchAll();
        model.addAttribute("forms",forms);

        return "inquiries";
    }

    @GetMapping("/save")
    public String save(Model model,
                       Form form){
        formService.add(form);
        return allInquiry(model);
    }
}
