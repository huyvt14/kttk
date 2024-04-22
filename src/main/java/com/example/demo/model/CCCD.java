package com.example.demo.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cccd")
public class CCCD {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "so")
	private String so;
	@Column(name = "ten")
	private String ten;
	@Column(name = "ngaysinh")
	private String ngaySinh;
	@Column (name = "gioitinh")
	private String gioiTinh;
	@Column (name ="quoctich")
	private String quocTich;
	@Column (name = "quequan")
	private String queQuan;
	@Column(name = "noithuongtru")
	private String noiThuonTru;
	@Column(name = "duongdan")
	private String duongDanAnhCC;

    public CCCD() {
    }
    public CCCD(int id, String so, String ten, String ngaySinh, String gioiTinh, String quocTich, String queQuan, String noiThuongTru) {
        this.id = id;
        this.so = so;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.queQuan = queQuan;
        this.noiThuonTru = noiThuongTru;
    }
}
