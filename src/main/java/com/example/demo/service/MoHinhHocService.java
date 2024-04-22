package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.MoHinhHocRepository;
import com.example.demo.model.MoHinhHoc;

@Service
public class MoHinhHocService {
	private final MoHinhHocRepository moHinhHocRepository;

    MoHinhHocService(MoHinhHocRepository moHinhHocRepository) {
        this.moHinhHocRepository = moHinhHocRepository;
    }
    public ArrayList<MoHinhHoc> layTatCaMoHinh(){
    	return moHinhHocRepository.findAll();
    }
    
    @Transactional(readOnly = false)
    public Float docChinhXacSo(int mohinhId) {
        return moHinhHocRepository.dochinhxacso(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float docChinhXacTen(int mohinhId) {
        return moHinhHocRepository.dochinhxacten(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float docChinhXacNgaySinh(int mohinhId) {
        return moHinhHocRepository.dochinhxacngaysinh(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float docChinhXacQuocTich(int mohinhId) {
        return moHinhHocRepository.dochinhxacquoctich(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float docChinhXacGioiTinh(int mohinhId) {
        return moHinhHocRepository.dochinhxacgioitinh(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float docChinhXacQueQuan(int mohinhId) {
        return moHinhHocRepository.dochinhxacquequan(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float docChinhXacNoiThuongTru(int mohinhId) {
        return moHinhHocRepository.dochinhxacnoithuongtru(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuSo(int mohinhId) {
        return moHinhHocRepository.dophuso(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuTen(int mohinhId) {
        return moHinhHocRepository.dophuten(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuNgaySinh(int mohinhId) {
        return moHinhHocRepository.dophungaysinh(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuQuocTich(int mohinhId) {
        return moHinhHocRepository.dophuquoctich(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuGioiTinh(int mohinhId) {
        return moHinhHocRepository.dophugioitinh(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuQueQuan(int mohinhId) {
        return moHinhHocRepository.dophuquequan(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float doPhuNoiThuongTru(int mohinhId) {
        return moHinhHocRepository.dophunoithuongtru(mohinhId);
    }
    @Transactional(readOnly = false)
    public Float thoiGianTrungBinh(int mohinh_id) {
        return moHinhHocRepository.thoigian(mohinh_id);
    }
    
}
