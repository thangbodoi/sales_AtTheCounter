package com.example.demospring.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IthongKeDoanhThuService {
    List<Object[]> doanhThuTheoNgay();

    List<Object[]> doanhThuTheoThang();

    List<Object[]> doanhThuTheoNam();
}
