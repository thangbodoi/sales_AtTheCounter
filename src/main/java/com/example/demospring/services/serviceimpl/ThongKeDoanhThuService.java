package com.example.demospring.services.serviceimpl;

import com.example.demospring.repository.IHoaDonCTRepository;
import com.example.demospring.services.IthongKeDoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ThongKeDoanhThuService implements IthongKeDoanhThuService {

    @Autowired
    private IHoaDonCTRepository hoaDonCTRepository;

    @Override
    public List<Object[]> doanhThuTheoNgay() {
        return hoaDonCTRepository.doanhThuTheoNgay();
    }

    @Override
    public List<Object[]> doanhThuTheoThang() {
        return hoaDonCTRepository.revenueByMonth();
    }

    @Override
    public List<Object[]> doanhThuTheoNam() {
        return hoaDonCTRepository.revenueByYear();
    }


}
