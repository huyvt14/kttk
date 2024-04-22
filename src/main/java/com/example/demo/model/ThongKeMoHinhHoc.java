package com.example.demo.model;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class ThongKeMoHinhHoc extends MoHinhHoc{
	private HashMap<String, Float> doChinhXac = new HashMap<>();
	private HashMap<String , Float> doPhu = new HashMap<>();
	private float thoiGianTrungBinh;
	
	public ThongKeMoHinhHoc() {
		super();
	}
	public ThongKeMoHinhHoc(ArrayList<Object> ob) {
		super();
		this.doChinhXac.put("so", (Float) ob.get(0));
		this.doChinhXac.put("ten", (Float) ob.get(1));
		this.doChinhXac.put("ngaysinh", (Float) ob.get(2));
		this.doChinhXac.put("gioitinh", (Float) ob.get(3));
		this.doChinhXac.put("quoctich", (Float) ob.get(4));
		this.doChinhXac.put("quequan", (Float) ob.get(5));
		this.doChinhXac.put("noithuongtru", (Float) ob.get(6));

		this.doPhu.put("so", (Float) ob.get(7));
		this.doPhu.put("ten", (Float) ob.get(8));
		this.doPhu.put("ngaysinh", (Float) ob.get(9));
		this.doPhu.put("gioitinh", (Float) ob.get(10));
		this.doPhu.put("quoctich", (Float) ob.get(11));
		this.doPhu.put("quequan", (Float) ob.get(12));
		this.doPhu.put("noithuongtru", (Float) ob.get(13));
		
		this.thoiGianTrungBinh = (Float) ob.get(14);
	}
}
