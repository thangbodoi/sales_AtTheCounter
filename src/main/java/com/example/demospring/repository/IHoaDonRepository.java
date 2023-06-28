package com.example.demospring.repository;

import com.example.demospring.models.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface IHoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query("select hd from HoaDon hd where (hd.idKH.ten like %:fields% or hd.tenNguoiNhan like " +
            "%:fields% or hd.idNV.ten like %:fields% " +
            "or hd.sdt like %:fields% " +
            "or hd.ma like %:fields% " +
            "or hd.diaChhi like %:fields%) and hd.tinhTrang = :tinhTrang and (hd.ngayTao between :startDate and :endDate)")
    Page<HoaDon> findHoaDonByFields(@Param("fields") String fields, @Param("tinhTrang") int tinhTrang, @Param("startDate") Date startDate
            ,@Param("endDate") Date endDate, Pageable pageable);


}
