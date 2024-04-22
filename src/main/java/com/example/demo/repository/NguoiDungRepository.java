package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer>{
	public NguoiDung findByTenDangNhapAndMatKhau(String tdn, String mk);
	public NguoiDung findByTenDangNhap(String tenDangNhap);
}
