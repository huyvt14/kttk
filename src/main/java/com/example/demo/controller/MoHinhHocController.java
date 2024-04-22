package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.MoHinhHoc;
import com.example.demo.model.ThongKeMoHinhHoc;
import com.example.demo.service.MoHinhHocService;

import jakarta.servlet.http.HttpSession;
@Controller
public class MoHinhHocController {
	private final MoHinhHocService moHinhHocService;

    MoHinhHocController(MoHinhHocService moHinhHocService) {
        this.moHinhHocService = moHinhHocService;
    }
    
    @GetMapping("/thongke")
    public String xuLyThongKe(HttpSession session, @RequestParam(name = "mohinh_id", defaultValue = "0") int mohinh_id ) {
    	ArrayList<MoHinhHoc> lmhh = moHinhHocService.layTatCaMoHinh();
    	if(mohinh_id == 0) {
    		mohinh_id = lmhh.get(lmhh.size()-1).getId();
    	}
    	session.setAttribute("lmhh", lmhh);
    	session.setAttribute("mohinh_id", mohinh_id);
        ArrayList<Object> results = new ArrayList<>();

        results.add(moHinhHocService.docChinhXacSo(mohinh_id));
        results.add(moHinhHocService.docChinhXacTen(mohinh_id));
        results.add(moHinhHocService.docChinhXacNgaySinh(mohinh_id));
        results.add(moHinhHocService.docChinhXacGioiTinh(mohinh_id));
        results.add(moHinhHocService.docChinhXacQuocTich(mohinh_id));
        results.add(moHinhHocService.docChinhXacQueQuan(mohinh_id));
        results.add(moHinhHocService.docChinhXacNoiThuongTru(mohinh_id));
        results.add(moHinhHocService.doPhuSo(mohinh_id));
        results.add(moHinhHocService.doPhuTen(mohinh_id));
        results.add(moHinhHocService.doPhuNgaySinh(mohinh_id));
        results.add(moHinhHocService.doPhuGioiTinh(mohinh_id));
        results.add(moHinhHocService.doPhuQuocTich(mohinh_id));
        results.add(moHinhHocService.doPhuQueQuan(mohinh_id));
        results.add(moHinhHocService.doPhuNoiThuongTru(mohinh_id));
        results.add(moHinhHocService.thoiGianTrungBinh(mohinh_id));
        	
    	ThongKeMoHinhHoc tk = new ThongKeMoHinhHoc(results);
    	session.setAttribute("tk", tk);
    	System.out.println(tk.toString());
    	return "thongke";
    }
}
