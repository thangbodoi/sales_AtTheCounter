package com.example.demospring.services;

import com.example.demospring.models.entity.ChucVu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IChucVuService {
    List<ChucVu> getList();

    ChucVu create(ChucVu chucVu);

    boolean delete(ChucVu chucVu);

    ChucVu update(ChucVu chucVu);

    Page<ChucVu> searchByFields(String fields, int page, int pageSize);

    ChucVu findChucVuById(UUID id);

    ChucVu findChucVuByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);

}
