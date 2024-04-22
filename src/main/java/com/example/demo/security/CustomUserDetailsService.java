//package com.example.demo.security;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.demo.model.NguoiDung;
//import com.example.demo.service.NguoiDungService;
//
//
//public class CustomUserDetailsService implements UserDetailsService{
//	private NguoiDungService nguoidungService;
//	
//	public CustomUserDetailsService(NguoiDungService nguoidungService) {
//		this.nguoidungService = nguoidungService;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
//		NguoiDung tk = nguoidungService.findByTenDangNhap(tenDangNhap);
//	    if (tk == null) {
//	        throw new UsernameNotFoundException("Không tìm thấy người dùng với tên đăng nhập: " + tenDangNhap);
//	    }
//	    else {
//	    	System.out.println("tên đăng nhập tồn tại");
//	    	return new User(tk.getTenDangNhap(), tk.getMatKhau(), mapR("ROLE_"+tk.getVaiTro().toUpperCase()));
//	    }
//	}
//	
//	private Collection<GrantedAuthority> mapR(String vaiTro){
//		return Collections.singletonList(new SimpleGrantedAuthority(vaiTro));
//	}
//	
//}
