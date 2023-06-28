package com.example.demospring.services;

import com.example.demospring.models.entity.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ICuaHangService {
    List<CuaHang> getList();

    CuaHang create(CuaHang cuaHang);

    boolean delete(CuaHang cuaHang);

    CuaHang update(CuaHang cuaHang);

    CuaHang findCuaHangById(UUID id);

    CuaHang findCuaHangByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);

    Page<CuaHang> searchByFields(String fields, int page, int sizePage);

}
