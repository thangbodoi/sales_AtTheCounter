package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.*;
import com.example.demospring.repository.IGioHangCTRepository;
import com.example.demospring.repository.IGioHangRepository;
import com.example.demospring.repository.IHoaDonCTRepository;
import com.example.demospring.repository.IKhachHangRepository;
import com.example.demospring.services.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseService implements IPurchaseService {
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Autowired
    private IGioHangCTRepository gioHangCTRepository;

    @Autowired
    private IHoaDonCTRepository hoaDonCTRepository;



    @Override
    public List<KhachHang> findKhachHangNotInGioHang() {
        return khachHangRepository.findKhachHangNotInGioHang();
    }

    @Override
    public Page<GioHangChiTiet> getListGhctOfGioHang(UUID idGioHang, String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return gioHangCTRepository.findByIdGioHangAndSearchByFields(idGioHang,fields,pageable);
    }

    @Override
    public GioHangChiTiet addOrUpdateGhct(GioHangChiTiet gioHangChiTiet) {
        return gioHangCTRepository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet findGioHangCtById(GioHang idGioHang, ChiTietSP idChiTietSp) {
        Optional<GioHangChiTiet> gioHangChiTiet = gioHangCTRepository.findByIdGioHangAndIdChiTietSP(idGioHang,idChiTietSp);
        return gioHangChiTiet.orElse(null);
    }

    @Override
    public boolean deleteGhct(GioHangChiTiet gioHangChiTiet) {
        try {
            gioHangCTRepository.delete(gioHangChiTiet);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void saveListHdct(List<HoaDonChiTiet> hoaDonChiTiets) {

            hoaDonCTRepository.saveAll(hoaDonChiTiets);


    }

    @Override
    public void deleteListGhct(List<GioHangChiTiet> gioHangChiTiets) {
        gioHangCTRepository.deleteAll(gioHangChiTiets);
    }


}
