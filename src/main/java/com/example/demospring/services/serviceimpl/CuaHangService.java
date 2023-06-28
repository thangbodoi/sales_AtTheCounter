package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.CuaHang;
import com.example.demospring.repository.ICuaHangRepository;
import com.example.demospring.services.ICuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangService implements ICuaHangService {

    @Autowired
    private ICuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getList() {
        return this.cuaHangRepository.findAll();
    }

    @Override
    public CuaHang create(CuaHang cuaHang) {
        cuaHang.setId(null);
        return this.cuaHangRepository.save(cuaHang);
    }

    @Override
    public boolean delete(CuaHang cuaHang) {
        try {
            this.cuaHangRepository.delete(cuaHang);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CuaHang update(CuaHang cuaHang) {
        if (this.cuaHangRepository.existsById(cuaHang.getId())) {
            return this.cuaHangRepository.save(cuaHang);
        }
        return null;
    }

    @Override
    public CuaHang findCuaHangById(UUID id) {
        Optional<CuaHang> khachHang = this.cuaHangRepository.findById(id);
        if (khachHang.isPresent()) {
            return khachHang.get();
        }
        return null;
    }

    @Override
    public CuaHang findCuaHangByMa(String ma) {
        Optional<CuaHang> cuaHang = this.cuaHangRepository.findByMa(ma);
        if (cuaHang.isPresent()) {
            return cuaHang.get();
        }
        return null;
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<CuaHang> cuaHang = cuaHangRepository.findByMaAndIdNot(ma, id);
        if (cuaHang.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<CuaHang> searchByFields(String fields, int page, int sizePage) {
        Pageable pageable = PageRequest.of(page - 1, sizePage);

        return cuaHangRepository.searchByFields(fields, pageable);
    }
}
