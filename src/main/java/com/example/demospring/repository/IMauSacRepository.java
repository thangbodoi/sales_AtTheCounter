package com.example.demospring.repository;

import com.example.demospring.models.entity.KhachHang;
import com.example.demospring.models.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IMauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query("SELECT ms FROM MauSac ms WHERE  ms.ma LIKE %:fields% or ms.ten like %:fields%")
    Page<MauSac> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma, UUID id);
}
