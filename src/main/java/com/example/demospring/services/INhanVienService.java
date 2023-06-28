package com.example.demospring.services;

import com.example.demospring.models.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface INhanVienService {
    List<NhanVien> getList();

    void create(NhanVien nhanVien);

    String delete(NhanVien nhanVien);

    NhanVien update(NhanVien nhanVien);

    NhanVien findNhanVienById(UUID id);

    Page<NhanVien> searchByFields(String fields, int page, int pageSize);

    NhanVien findNhanVienByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);

    List<NhanVien> getListNhanVienWithChucVu(String tenCv);

    NhanVien findNhanVienBySdt(String sdt);


}
