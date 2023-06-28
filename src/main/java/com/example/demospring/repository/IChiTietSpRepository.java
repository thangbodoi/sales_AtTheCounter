package com.example.demospring.repository;

import com.example.demospring.models.entity.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IChiTietSpRepository extends JpaRepository<ChiTietSP, UUID> {

    @Query("SELECT ctsp FROM ChiTietSP ctsp where ctsp.idSP.ten like %:fields% or ctsp.idMauSac.ten like %:fields% or ctsp.idNsx.ten like %:fields% or ctsp.idDongSP.ten like %:fields%")
    Page<ChiTietSP> searchByFields(@Param("fields") String fields, Pageable pageable);

}
