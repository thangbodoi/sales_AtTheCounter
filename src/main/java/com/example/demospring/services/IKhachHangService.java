package com.example.demospring.services;

import com.example.demospring.models.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IKhachHangService {
    List<KhachHang> getAll();

    String delete(KhachHang khachHang);

    void add(KhachHang khachHang);

    KhachHang update(KhachHang khachHang);

    KhachHang findKhachHangById(UUID id);

    Page<KhachHang> getKhachHangPage(int page, int pageSize);

    Page<KhachHang> searchByFields(String fields, int page, int sizePage);

    KhachHang findKhachHangByMa(String ma);

    boolean findByMaAndIdNot(String ma, UUID id);

}
