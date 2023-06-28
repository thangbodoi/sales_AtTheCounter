package com.example.demospring.repository;

import com.example.demospring.models.entity.SanPham;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query("Select sp from SanPham sp where sp.ma like %:fields% or sp.ten like %:fields%")
    Page<SanPham> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma, UUID id);
}
