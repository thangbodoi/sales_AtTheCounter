package com.example.demospring.repository;

import com.example.demospring.models.entity.KhachHang;
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
public interface IKhachHangRepository extends JpaRepository<KhachHang, UUID> {
    //Search
    @Query("SELECT kh FROM KhachHang kh WHERE kh.ma LIKE %:fields% or kh.ten like %:fields% or kh.sdt like %:fields%")
    Page<KhachHang> searchByFields(@Param("fields") String fields, Pageable pageable);

    @Query("select kh from KhachHang kh where kh not in (Select gh.idKH from GioHang gh)")
    List<KhachHang> findKhachHangNotInGioHang();

    Optional findByMa(@Param("ma") String ma);

    KhachHang findByMaAndIdNot(String ma, UUID id);
}
