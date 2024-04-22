package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.CCCD;

public interface CCCDRepository extends JpaRepository<CCCD, Integer>{

//	@Procedure(name = "xemchitiet", procedureName="kientructhietke.xemchitiet")
//	ArrayList<CCCD> xemchitiet(@Param("muc") String muc, @Param("mohinh_id") int mohinh_id);
}
