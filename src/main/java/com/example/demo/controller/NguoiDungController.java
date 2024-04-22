package com.example.demo.controller;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.NguoiDungService;
@Controller
public class NguoiDungController {
	private final NguoiDungService nguoiDungService;

    NguoiDungController(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }
    @GetMapping("/")
    public String xuLyKhoiDau() {
    	return "dangnhap";
    }
    
    @PostMapping("/dangnhap")
    public String xuLyDangNhap(@RequestParam("tenDangNhap")String u, @RequestParam("matKhau")String p) {
    	System.out.println("xử lý đăng nhập ");
    	// Xác thực thông tin đăng nhập
        return "redirect:/chonanh";
    }
//    @GetMapping("/chontrang")
//    public String chontrang() {
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.getAuthorities());
//        // Kiểm tra vai trò của người dùng và chuyển hướng tùy thuộc vào vai trò
//        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_QTV"))) {
//            return "redirect:/trangchu"; // Chuyển hướng đến trang chính cho quản trị viên
//        } else if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ND"))) {
//            return "redirect:/trangchund"; // Chuyển hướng đến trang chính cho người dùng
//        } else {
//            return "redirect:/"; // Chuyển hướng mặc định
//        }
//    }
    @GetMapping("/trangchu")
    public String trangchu() {
    	return "trangchu";
    }
    @GetMapping("/trangchund")
    public String trangchund() {
    	return "trangchund";
    }
}
