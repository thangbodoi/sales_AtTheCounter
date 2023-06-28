package com.example.demospring.repository;

import com.example.demospring.models.entity.ChiTietSP;
import com.example.demospring.models.entity.GioHang;
import com.example.demospring.models.entity.GioHangChiTiet;
import com.example.demospring.models.entity.GioHangChiTietId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IGioHangCTRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {

    @Query("select ghct from GioHangChiTiet ghct where ghct.idGioHang.id = :idGioHang " +
            "and (ghct.idChiTietSP.idSP.ten like %:fields% or ghct.idChiTietSP.idNsx.ten like %:fields% " +
            "or ghct.idChiTietSP.idDongSP.ten like %:fields% " +
            "or ghct.idChiTietSP.idMauSac.ten like %:fields%)")
    Page<GioHangChiTiet> findByIdGioHangAndSearchByFields(@Param("idGioHang") UUID idGioHang, @Param("fields") String fields, Pageable pageable);

    Optional findByIdGioHangAndIdChiTietSP(GioHang idGioHang, ChiTietSP idChiTietSP);
}
