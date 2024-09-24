package com.example.springkadaiform.repository;

import com.example.springkadaiform.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry,Integer> {
}
