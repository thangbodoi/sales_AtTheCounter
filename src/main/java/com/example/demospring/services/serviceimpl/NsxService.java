package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.NSX;
import com.example.demospring.repository.INsxRepository;
import com.example.demospring.services.INsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NsxService implements INsxService {

    @Autowired
    private INsxRepository nsxRepository;

    @Override
    public List<NSX> getList() {
        return nsxRepository.findAll();
    }

    @Override
    public NSX create(NSX nsx) {
        nsx.setId(null);
        return nsxRepository.save(nsx);
    }

    @Override
    public boolean delete(NSX nsx) {
        try {
            nsxRepository.delete(nsx);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public NSX update(NSX nsx) {
        try {
            if (nsxRepository.existsById(nsx.getId())) {
                return nsxRepository.save(nsx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<NSX> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return nsxRepository.searchByFields(fields, pageable);
    }

    @Override
    public NSX findNsxById(UUID id) {
        Optional<NSX> nsx = nsxRepository.findById(id);
        if (nsx.isPresent()) {
            return nsx.get();
        } else {
            return null;
        }
    }

    @Override
    public NSX findNsxByMa(String ma) {
        Optional<NSX> nsx = nsxRepository.findByMa(ma);
        if (nsx.isPresent()) {
            return nsx.get();
        } else {
            return null;
        }
    }


    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<NSX> nsx = nsxRepository.findByMaAndIdNot(ma, id);
        if (nsx.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
