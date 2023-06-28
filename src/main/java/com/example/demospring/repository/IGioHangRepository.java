package com.example.demospring.repository;

import com.example.demospring.models.entity.GioHang;
import com.example.demospring.models.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IGioHangRepository extends JpaRepository<GioHang, UUID> {
//    or gh.idNV.ten like %:fields%
    @Query("SELECT gh FROM GioHang gh where gh.ma LIKE %:fields% or gh.diaChi LIKE %:fields% or gh.sdt LIKE %:fields% or gh.idKH.ten like %:fields%   or gh.tenNguoiNhan like %:fields%")
    Page<GioHang> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma,UUID id);

    @Transactional //dược sử dụng để bảo đảm tính toàn vẹn của giao dịch.
    @Modifying //thông báo rằng câu lệnh JPQL sẽ thực hiện một thao tác cập nhật.
    @Query("update GioHang gh set gh.tinhTrang = case when size(gh.listGioHangChiTiet) > 0 then 1 else 0 end ")
    void updateTrangThaiByGioHangChiTiet();
}
