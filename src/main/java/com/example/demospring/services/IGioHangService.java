package com.example.demospring.services;

import com.example.demospring.models.entity.GioHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IGioHangService {
    List<GioHang> getList();

    GioHang create(GioHang gioHang);

    boolean delete(GioHang gioHang);

    GioHang update(GioHang gioHang);

    Page<GioHang> searchByFields(String fields, int page, int pageSize);

    GioHang findGioHangById(UUID id);

    GioHang findGioHangByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);

}
