package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.SanPham;
import com.example.demospring.repository.ISanPhamRepository;
import com.example.demospring.services.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    private ISanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getList() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham create(SanPham sanPham) {
        sanPham.setId(null);
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public boolean delete(SanPham sanPham) {
        try {
            sanPhamRepository.delete(sanPham);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SanPham update(SanPham sanPham) {
        try {
            if (sanPhamRepository.existsById(sanPham.getId())) {
              return   sanPhamRepository.save(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<SanPham> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);

        return sanPhamRepository.searchByFields(fields, pageable);
    }

    @Override
    public SanPham findSanPhamById(UUID id) {
        Optional<SanPham> sanPham = sanPhamRepository.findById(id);
        if (sanPham.isPresent()) {
            return sanPham.get();
        }
        return null;
    }

    @Override
    public SanPham findSanPhamByMa(String ma) {
        Optional<SanPham> sanPham = sanPhamRepository.findByMa(ma);
        if (sanPham.isPresent()) {
            return sanPham.get();
        }
        return null;
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<SanPham> sanPham = sanPhamRepository.findByMaAndIdNot(ma, id);
        if (sanPham.isPresent()) {
            return true;
        }
        return false;
    }


}
