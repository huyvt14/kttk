package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.MauHuanLuyen;
import com.example.demo.service.MauHuanLuyenService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MauHuanLuyenController {
	private final MauHuanLuyenService mauHuanLuyenService;
	private static final String DD ="src/main/resources/static/mauhuanluyen/";
	
    MauHuanLuyenController(MauHuanLuyenService mauHuanLuyenService) {
        this.mauHuanLuyenService = mauHuanLuyenService;
    }
    
    @GetMapping("/mauhuanluyen")
    public String mauHuanLuyen() {
    	return "mauhuanluyen";
    }
    
    @GetMapping("/xemmauhuanluyen")
    public String layMauHuanLuyen(HttpSession session, @RequestParam("muctk") String m) {
    	ArrayList<MauHuanLuyen> lmhl = mauHuanLuyenService.layDanhSachMauHuanLuyenTheoMuc(m);
    	session.setAttribute("lmhl", lmhl);
    	session.setAttribute("muctk", m);
    	return "mauhuanluyen";
    }
    
    @PostMapping("/themmauhuanluyen")
    public String xuLyThemMauHuanLuyen(HttpSession session, @RequestParam("file") MultipartFile file, @RequestParam("muct") String m) {
    	if (!file.isEmpty()) {
            try {
            	String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
                String fileName = System.currentTimeMillis() + "_" + originalFileName;
                String tg = DD  + m +"/";
                Path uploadPath = Paths.get(tg);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                try (InputStream inputStream = file.getInputStream()) {
                    Files.copy(inputStream, uploadPath.resolve(fileName));
                    System.out.print("ghi thành công");
                    inputStream.close();
                    MauHuanLuyen mhl = new MauHuanLuyen(fileName, m);
                    mauHuanLuyenService.themMauHuanLuyen(mhl);
                	System.out.println("xử lý thêm thành công");
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.out.print("ghi thất bại");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.print("xử lý thất bại");
            }
    	}
    	return "redirect:/xemmauhuanluyen?muctk="+m;
    }
    
    @GetMapping("/xoamauhuanluyen")
    public String xoaMauHuanLuyen(HttpSession session, @RequestParam("id") int id, @RequestParam("ten") String ten) {
    	try {
    		mauHuanLuyenService.xoaMauHuanLuyen(id);
    		Path filePath = Paths.get(DD).resolve(ten);        
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("xóa thành công");
            } else {
            	System.out.print("đường dẫn sai");
            }
    	}
    	catch(Exception e){
    	}
    	System.out.println("xử lý xóa thành công");
    	return "redirect:/xemmauhuanluyen?muctk="+session.getAttribute("muctk");
    }
    
    @GetMapping("/anh/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName) throws IOException {
        File serverFile = new File(DD+"/so/"+ imageName);
        return Files.readAllBytes(serverFile.toPath());
    }
}
