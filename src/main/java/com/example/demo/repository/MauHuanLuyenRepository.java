package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MauHuanLuyen;

public interface MauHuanLuyenRepository extends JpaRepository<MauHuanLuyen, Integer>{
	ArrayList<MauHuanLuyen> findAllByMucThongTin(String muc);
}
