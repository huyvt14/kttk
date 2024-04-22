package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "nguoidung")
public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ten;
	@Column(name = "tendangnhap")
	private String tenDangNhap;
	@Column(name = "matkhau")
	private String matKhau;
	@Column(name = "vaitro")
	private String vaiTro;
	@Column(name = "mota")
	private String moTa;
}
