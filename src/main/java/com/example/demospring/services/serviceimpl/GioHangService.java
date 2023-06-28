package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.GioHang;
import com.example.demospring.repository.IGioHangRepository;
import com.example.demospring.services.IGioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GioHangService implements IGioHangService {

    @Autowired
    private IGioHangRepository gioHangRepository;

    @Override
    public List<GioHang> getList() {
        return gioHangRepository.findAll();
    }

    @Override
    public GioHang create(GioHang gioHang) {
        gioHang.setId(null);
        try {
            return  gioHangRepository.save(gioHang);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean delete(GioHang gioHang) {
        try {
            gioHangRepository.delete(gioHang);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public GioHang update(GioHang gioHang) {
        Optional<GioHang> gioHang1 = gioHangRepository.findById(gioHang.getId());
        if(gioHang1.isPresent()){
            return gioHangRepository.save(gioHang);
        }else{
            return null;
        }
    }

    @Override
    public Page<GioHang> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1,pageSize);
        gioHangRepository.updateTrangThaiByGioHangChiTiet();
        return gioHangRepository.searchByFields(fields,pageable);
    }

    @Override
    public GioHang findGioHangById(UUID id) {
        Optional<GioHang> gioHang = gioHangRepository.findById(id);
        if(gioHang.isPresent()){
         return    gioHang.get();
        }
        return null;
    }

    @Override
    public GioHang findGioHangByMa(String ma) {
        Optional<GioHang> gioHang = gioHangRepository.findByMa(ma);
        if(gioHang.isPresent()){
            return gioHang.get();
        }
        return null;
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<GioHang> gioHang = gioHangRepository.findByMaAndIdNot(ma,id);
        if(gioHang.isPresent()){
            return true;
        }
        return false;
    }
}
