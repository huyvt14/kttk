package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.NguoiDung;
import com.example.demo.repository.NguoiDungRepository;

@Service
public class NguoiDungService {
	private NguoiDungRepository nguoiDungRepository;

    NguoiDungService(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }
    public boolean kiemTraDangNhap(NguoiDung nd) {
    	NguoiDung nguoiDung = new NguoiDung();
    	nguoiDung= nguoiDungRepository.findByTenDangNhapAndMatKhau(nd.getTenDangNhap(), nd.getMatKhau());
    	if(nguoiDung != null) {
    		nd.setTen(nguoiDung.getTen());
    		nd.setVaiTro(nguoiDung.getVaiTro());
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public NguoiDung findByTenDangNhap(String tenDangNhap) {
    	return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
    }
}
