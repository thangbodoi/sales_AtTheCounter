package com.example.demospring.repository;

import com.example.demospring.models.entity.KhachHang;
import com.example.demospring.models.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("SELECT kh FROM NhanVien kh WHERE kh.idCH.ten like %:fields% or kh.idCV.ten like %:fields% or kh.ma LIKE %:fields% or kh.ten like %:fields% or kh.sdt like %:fields%")
    Page<NhanVien> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma, UUID id);

    Optional findBySdt(String sdt);

    @Query("SELECT nv FROM NhanVien nv WHERE nv.idCV.ten = :tenCv")
    List<NhanVien> findAllByCv(@Param("tenCv") String tenCv);

}
