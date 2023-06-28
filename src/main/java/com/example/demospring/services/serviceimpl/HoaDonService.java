package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.HoaDon;
import com.example.demospring.repository.IHoaDonCTRepository;
import com.example.demospring.repository.IHoaDonRepository;
import com.example.demospring.services.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonService implements IHoaDonService {

    @Autowired
    private IHoaDonRepository hoaDonRepository;

    @Autowired
    private IHoaDonCTRepository hoaDonCTRepository;

    @Override
    public List<HoaDon> getList() {
        return this.hoaDonRepository.findAll();
    }

    @Override
    public HoaDon create(HoaDon hoaDon) {
        hoaDon.setId(null);
        hoaDon.setNgayTao(new Date(System.currentTimeMillis()));
        hoaDon.setTinhTrang(0);
        return this.hoaDonRepository.save(hoaDon);
    }

    @Override
    public String delete(HoaDon hoaDon) {
        try {
            this.hoaDonRepository.delete(hoaDon);
            return "Xóa thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Không xóa được!";
        }

    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        if (this.hoaDonRepository.existsById(hoaDon.getId())) {
            hoaDon.setTinhTrang(1);
            hoaDon.setNgayThanhToan(new Date(System.currentTimeMillis()));
         return this.hoaDonRepository.save(hoaDon);
        }
        return null;
    }

    @Override
    public long coutnHoaDon() {
        return hoaDonRepository.count();
    }

    @Override
    public HoaDon findHoaDonById(UUID id) {
        Optional<HoaDon> hoaDon = this.hoaDonRepository.findById(id);
        if (hoaDon.isPresent()) {
            return hoaDon.get();
        }
        return null;
    }

    @Override
    public double totalAmountOfHoaDon(HoaDon hoaDon) {
        return this.hoaDonCTRepository.totalAmountOf(hoaDon);
    }

    @Override
    public Page<HoaDon> searchHoaDonByFields(String fields,int tinhTrang,Date startDate,Date endDate, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1,pageSize);
        return this.hoaDonRepository.findHoaDonByFields(fields,tinhTrang,startDate,endDate,pageable);
    }
}
