package com.example.demospring.services;

import com.example.demospring.models.entity.ChiTietSP;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IChiTietSanPhamService {
    List<ChiTietSP> getList();

    boolean delete(ChiTietSP chiTietSP);

    ChiTietSP update(ChiTietSP chiTietSP);

    ChiTietSP create(ChiTietSP chiTietSP);

    ChiTietSP findById(UUID id);

    Page<ChiTietSP> searchByFields(String fields, int page, int pageSize);

}
