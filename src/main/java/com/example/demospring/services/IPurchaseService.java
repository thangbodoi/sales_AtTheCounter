package com.example.demospring.services;

import com.example.demospring.models.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IPurchaseService {
    List<KhachHang> findKhachHangNotInGioHang();

    Page<GioHangChiTiet> getListGhctOfGioHang(UUID idGioHang, String fields, int page, int pageSize);

    GioHangChiTiet addOrUpdateGhct(GioHangChiTiet gioHangChiTiet);

    GioHangChiTiet findGioHangCtById(GioHang idGioHang, ChiTietSP idChiTietSp);


    boolean deleteGhct(GioHangChiTiet gioHangChiTiet);

    void saveListHdct(List<HoaDonChiTiet> hoaDonChiTiets);

    void deleteListGhct(List<GioHangChiTiet> gioHangChiTiets);


}
