package com.example.demospring.repository;

import com.example.demospring.models.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IChucVuRepository extends JpaRepository<ChucVu, UUID> {

    @Query("SELECT cv FROM ChucVu cv WHERE cv.ma LIKE %:fields% OR cv.ten LIKE %:fields%")
    Page<ChucVu> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma, UUID id);
}
