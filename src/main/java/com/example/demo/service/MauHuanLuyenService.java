package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.model.MauHuanLuyen;
import com.example.demo.repository.MauHuanLuyenRepository;

@Service
public class MauHuanLuyenService {
	private final MauHuanLuyenRepository mauHuanLuyenRepository;

    MauHuanLuyenService(MauHuanLuyenRepository mauHuanLuyenRepository) {
        this.mauHuanLuyenRepository = mauHuanLuyenRepository;
    }
    public ArrayList<MauHuanLuyen> layDanhSachMauHuanLuyenTheoMuc(String muc){
    	return mauHuanLuyenRepository.findAllByMucThongTin(muc);
    }
    public void xoaMauHuanLuyen(int id) {
    	mauHuanLuyenRepository.deleteById(id);
    }
    public void themMauHuanLuyen(MauHuanLuyen mhl) {
    	mauHuanLuyenRepository.save(mhl);
    }
}
