package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.MoHinhHoc;
@Transactional
public interface MoHinhHocRepository extends JpaRepository<MoHinhHoc, Integer>{
	
//	@Procedure(name = "kientructhietke.thongke")
//	thongke(@Param("mohinh_id") int mohinhId);
	
	ArrayList<MoHinhHoc> findAll();
	
	@Procedure(name = "dochinhxacso", procedureName="kientructhietke.dochinhxacso")
	Float dochinhxacso(@Param("mohinh_id")int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dochinhxacten")
	Float dochinhxacten(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dochinhxacngaysinh")
	Float dochinhxacngaysinh(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dochinhxacquoctich")
	Float dochinhxacquoctich(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dochinhxacgioitinh")
	Float dochinhxacgioitinh(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dochinhxacquequan")
	Float dochinhxacquequan(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dochinhxacnoithuongtru")
	Float dochinhxacnoithuongtru(@Param("mohinh_id") int mohinh_id);
	
//	độ phủ
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophuso")
	Float dophuso(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophuten")
	Float dophuten(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophungaysinh")
	Float dophungaysinh(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophuquoctich")
	Float dophuquoctich(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophugioitinh")
	Float dophugioitinh(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophuquequan")
	Float dophuquequan(@Param("mohinh_id") int mohinh_id);
	
	@Procedure(name = "thoigian", procedureName="kientructhietke.dophunoithuongtru")
	Float dophunoithuongtru(@Param("mohinh_id") int mohinh_id);
	
//	thời gian trung bình 
	@Procedure(name = "thoigian", procedureName="kientructhietke.thoigian")
	Float thoigian(@Param("mohinh_id") int mohinh_id);
}
