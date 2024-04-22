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
@Table(name = "mauhuanluyen")
public class MauHuanLuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ten;
	@Column(name = "mucthongtin")
	private String mucThongTin;
	@Column(name = "mota")
	private String moTa;
	
	public MauHuanLuyen() {
		
	}
	
	public MauHuanLuyen(String ten, String muc) {
		this.ten = ten;
		this.mucThongTin = muc;
	}
}
