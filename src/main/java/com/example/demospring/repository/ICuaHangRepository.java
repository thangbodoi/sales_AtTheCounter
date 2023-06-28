package com.example.demospring.repository;

import com.example.demospring.models.entity.CuaHang;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query("select ch from CuaHang ch where ch.ma like %:fields% or ch.ten like %:fields% or ch.diaChi like %:fields%")
    Page<CuaHang> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma, UUID id);
}
