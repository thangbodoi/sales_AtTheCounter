package com.example.demospring.services;

import com.example.demospring.models.entity.DongSP;
import com.example.demospring.models.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ISanPhamService {
    List<SanPham> getList();

    SanPham create(SanPham sanPham);

    boolean delete(SanPham sanPham);

    SanPham update(SanPham sanPham);

    Page<SanPham> searchByFields(String fields, int page, int pageSize);

    SanPham findSanPhamById(UUID id);

    SanPham findSanPhamByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);


}
