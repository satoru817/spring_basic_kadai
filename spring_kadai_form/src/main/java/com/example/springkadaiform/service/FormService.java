package com.example.springkadaiform.service;

import com.example.springkadaiform.entity.Form;
import com.example.springkadaiform.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {
    private FormRepository formRepository;

    public FormService(FormRepository formRepository){
        this.formRepository = formRepository;
    }

    public List<Form> fetchAll(){
        return formRepository.findAll();
    }

    public void add(Form form){
        formRepository.save(form);
    }
}
