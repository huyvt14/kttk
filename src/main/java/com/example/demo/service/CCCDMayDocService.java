package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.CCCDMayDoc;
import com.example.demo.repository.CCCDMayDocRepository;
@Service
public class CCCDMayDocService {
	private final CCCDMayDocRepository cccdMayDocRepository;

    CCCDMayDocService(CCCDMayDocRepository cccdMayDocRepository) {
        this.cccdMayDocRepository = cccdMayDocRepository;
    }
    @Transactional(readOnly = false)
    public ArrayList<CCCDMayDoc> xemChiTiet(String m, int id){
    	return cccdMayDocRepository.xemchitiet(m, id);
    }
    public CCCDMayDoc tiemKiemCCCDMayDoc(int id) {
    	return cccdMayDocRepository.findById(id);
    }
    public void luuCCCDMayDoc(CCCDMayDoc cc) {
    	cccdMayDocRepository.save(cc);
    }
}
