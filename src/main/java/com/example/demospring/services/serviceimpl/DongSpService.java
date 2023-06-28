package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.DongSP;
import com.example.demospring.repository.IDongSPRepository;
import com.example.demospring.services.IDongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DongSpService implements IDongSPService {

    @Autowired
    private IDongSPRepository dongSPRepository;

    @Override
    public List<DongSP> getList() {
        return dongSPRepository.findAll();
    }

    @Override
    public DongSP create(DongSP dongSP) {
        dongSP.setId(null);
        return dongSPRepository.save(dongSP);
    }

    @Override
    public boolean delete(DongSP dongSP) {
        try {
            dongSPRepository.delete(dongSP);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DongSP update(DongSP dongSP) {
        Optional<DongSP> dsp = dongSPRepository.findById(dongSP.getId());
        if (dsp.isPresent()) {
            return dongSPRepository.save(dongSP);
        }
        return null;
    }

    @Override
    public Page<DongSP> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return dongSPRepository.searchByFields(fields, pageable);
    }

    @Override
    public DongSP findDongSpById(UUID id) {
        Optional<DongSP> dsp = dongSPRepository.findById(id);
        if (dsp.isPresent()) {
            return dsp.get();
        }
        return null;
    }

    @Override
    public DongSP findDongSPByMa(String ma) {
        Optional<DongSP> dsp = dongSPRepository.findByMa(ma);
        if (dsp.isPresent()) {
            return dsp.get();
        }
        return null;
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<DongSP> dsp = dongSPRepository.findByMaAndIdNot(ma, id);
        if (dsp.isPresent()) {
            return true;
        }
        return false;
    }
}
