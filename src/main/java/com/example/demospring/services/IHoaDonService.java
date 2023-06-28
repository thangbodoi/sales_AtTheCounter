package com.example.demospring.services;

import com.example.demospring.models.entity.HoaDon;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface IHoaDonService {
    List<HoaDon> getList();

    HoaDon create(HoaDon hoaDon);

    String delete(HoaDon hoaDon);

    HoaDon update(HoaDon hoaDon);

    long coutnHoaDon();

    HoaDon findHoaDonById(UUID id);

    double totalAmountOfHoaDon(HoaDon hoaDon);

    Page<HoaDon> searchHoaDonByFields(String fields, int tinhTrang, Date startDate,Date endDate, int page, int pageSize);
}
