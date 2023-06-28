package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.KhachHang;
import com.example.demospring.repository.IKhachHangRepository;
import com.example.demospring.services.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private IKhachHangRepository iKhachHangRepository;


    @Override
    public List<KhachHang> getAll() {
        return iKhachHangRepository.findAll();
    }

    @Override
    public String delete(KhachHang khachHang) {
        try {
            iKhachHangRepository.delete(khachHang);
            return "Delete complete!";
        } catch (Exception e) {
            return "Delete false!";
        }

    }

    @Override
    public void add(KhachHang khachHang) {
//        khachHang.setId(null);//chắc chắn thêm mới
        iKhachHangRepository.save(khachHang);
    }


    @Override
    public KhachHang findKhachHangById(UUID id) {
        Optional<KhachHang> khachHangOptional = iKhachHangRepository.findById(id);
        if (khachHangOptional.isPresent()) {
            return khachHangOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<KhachHang> getKhachHangPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return iKhachHangRepository.findAll(pageable);
    }

    @Override
    public Page<KhachHang> searchByFields(String fields, int page, int sizePage) {
        Pageable pageable = PageRequest.of(page - 1, sizePage);
        return iKhachHangRepository.searchByFields(fields, pageable);
    }

    @Override
    public KhachHang findKhachHangByMa(String ma) {
        Optional<KhachHang> khachHangOptional = iKhachHangRepository.findByMa(ma);
        if (khachHangOptional.isPresent()) {
            return khachHangOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean findByMaAndIdNot(String ma, UUID id) {
        KhachHang existingKhachHang = iKhachHangRepository.findByMaAndIdNot(ma, id);
        if (existingKhachHang != null) {
            return true;
        }
        return false;
    }

    @Override
    public KhachHang
    update(KhachHang khachHang) {
        UUID id = khachHang.getId();
        boolean isKhachHangExisted = iKhachHangRepository.existsById(id);
        if (isKhachHangExisted) {
            return iKhachHangRepository.save(khachHang);
        }
        return null;
    }
}
