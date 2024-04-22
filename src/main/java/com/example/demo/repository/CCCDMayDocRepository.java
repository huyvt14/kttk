package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CCCDMayDoc;

public interface CCCDMayDocRepository extends JpaRepository<CCCDMayDoc, Integer>{
	@Procedure(name = "xemchitiet", procedureName="kientructhietke.xemchitiet")
	ArrayList<CCCDMayDoc> xemchitiet(@Param("muc") String muc, @Param("mohinh_id") int mohinh_id);
	CCCDMayDoc findById(int id);
}
