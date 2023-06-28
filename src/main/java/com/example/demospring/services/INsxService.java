package com.example.demospring.services;

import com.example.demospring.models.entity.DongSP;
import com.example.demospring.models.entity.NSX;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface INsxService {
    List<NSX> getList();

    NSX create(NSX nsx);

    boolean delete(NSX nsx);

    NSX update(NSX nsx);

    Page<NSX> searchByFields(String fields, int page, int pageSize);

    NSX findNsxById(UUID id);

    NSX findNsxByMa(String ma);

    boolean isMaAndIdNot(String ma, UUID id);


}
