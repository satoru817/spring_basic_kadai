package com.example.springkadaiform.service;

import com.example.springkadaiform.entity.Inquiry;
import com.example.springkadaiform.repository.InquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryService {
    private InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository){
        this.inquiryRepository = inquiryRepository;
    }

    public void save(Inquiry inq){
        inquiryRepository.save(inq);
    }

    public List<Inquiry> fetchAll(){
        return inquiryRepository.findAll();
    }
}
