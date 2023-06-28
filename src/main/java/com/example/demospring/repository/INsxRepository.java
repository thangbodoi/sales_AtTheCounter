package com.example.demospring.repository;

import com.example.demospring.models.entity.NSX;
import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

@Registered
public interface INsxRepository extends JpaRepository<NSX, UUID> {

    @Query("select nsx from NSX nsx where nsx.ma like %:fields% or nsx.ten like %:fields%")
    Page<NSX> searchByFields(@Param("fields") String fields, Pageable pageable);

    Optional findByMa(String ma);

    Optional findByMaAndIdNot(String ma, UUID id);
}
