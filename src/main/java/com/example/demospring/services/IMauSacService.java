package com.example.demospring.services;

import com.example.demospring.models.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IMauSacService {
    List<MauSac> getList();

    String create(MauSac mauSac);

    String delete(MauSac mauSac);

    MauSac update(MauSac mauSac);

    MauSac findMauSacById(UUID id);

    Page<MauSac> searchByFields(String fields, int page, int sizePage);

    MauSac findMauSacByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);

}
