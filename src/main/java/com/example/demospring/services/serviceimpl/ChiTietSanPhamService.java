package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.ChiTietSP;
import com.example.demospring.repository.IChiTietSpRepository;
import com.example.demospring.services.IChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamService implements IChiTietSanPhamService {

    @Autowired
    private IChiTietSpRepository chiTietSpRepository;

    @Override
    public List<ChiTietSP> getList() {
        return chiTietSpRepository.findAll();
    }

    @Override
    public boolean delete(ChiTietSP chiTietSP) {
        try {
            chiTietSpRepository.delete(chiTietSP);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public ChiTietSP update(ChiTietSP chiTietSP) {
        if (chiTietSpRepository.existsById(chiTietSP.getId())) {
            return chiTietSpRepository.save(chiTietSP);
        }

        return null;
    }

    @Override
    public ChiTietSP create(ChiTietSP chiTietSP) {
        chiTietSP.setId(null);
        try {
            return chiTietSpRepository.save(chiTietSP);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChiTietSP findById(UUID id) {
        Optional<ChiTietSP> chiTietSp = chiTietSpRepository.findById(id);
        if (chiTietSp.isPresent()) {
            return chiTietSp.get();
        }
        return null;
    }

    @Override
    public Page<ChiTietSP> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return chiTietSpRepository.searchByFields(fields, pageable);
    }
}
