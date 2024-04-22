package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.CCCD;
import com.example.demo.repository.CCCDRepository;

@Service
public class CCCDService {
	private final CCCDRepository cccdRepository;

    CCCDService(CCCDRepository cccdRepository) {
        this.cccdRepository = cccdRepository;
    }
//    public ArrayList<CCCD> xemChiTiet(String m, int id){
//    	return cccdRepository.xemchitiet(m, id);
//    }
}
