package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.ChucVu;
import com.example.demospring.repository.IChucVuRepository;
import com.example.demospring.services.IChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuService implements IChucVuService {
    @Autowired
    private IChucVuRepository chucVuRepository;


    @Override
    public List<ChucVu> getList() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu create(ChucVu chucVu) {
        chucVu.setId(null);
        return chucVuRepository.save(chucVu);
    }

    @Override
    public boolean delete(ChucVu chucVu) {
        try {
            chucVuRepository.delete(chucVu);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ChucVu update(ChucVu chucVu) {
        Optional<ChucVu> chucVu1 = chucVuRepository.findById(chucVu.getId());
        if (chucVu1.isPresent()) {
            return chucVuRepository.save(chucVu);
        } else {
            return null;
        }
    }

    @Override
    public Page<ChucVu> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return chucVuRepository.searchByFields(fields, pageable);
    }

    @Override
    public ChucVu findChucVuById(UUID id) {
        Optional<ChucVu> chucVu = chucVuRepository.findById(id);
        if (chucVu.isPresent()) {
            return chucVu.get();
        } else {
            return null;
        }
    }

    @Override
    public ChucVu findChucVuByMa(String ma) {
        Optional<ChucVu> chucVu = chucVuRepository.findByMa(ma);
        if (chucVu.isPresent()) {
            return chucVu.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<ChucVu> chucVu = chucVuRepository.findByMaAndIdNot(ma, id);
        if (chucVu.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
