package com.example.demospring.services;

import com.example.demospring.models.entity.ChucVu;
import com.example.demospring.models.entity.DongSP;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IDongSPService {
    List<DongSP> getList();

    DongSP create(DongSP dongSP);

    boolean delete(DongSP dongSP);

    DongSP update(DongSP dongSP);

    Page<DongSP> searchByFields(String fields, int page, int pageSize);

    DongSP findDongSpById(UUID id);

    DongSP findDongSPByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);

}
