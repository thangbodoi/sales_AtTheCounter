package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.MauSac;
import com.example.demospring.repository.IMauSacRepository;
import com.example.demospring.services.IMauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacService implements IMauSacService {

    @Autowired
    private IMauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getList() {
        return mauSacRepository.findAll();
    }

    @Override
    public String create(MauSac mauSac) {
        try {
            mauSac.setId(null);
            mauSacRepository.save(mauSac);
            return "Thêm thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Thêm thất bại!";

        }
    }

    @Override
    public String delete(MauSac mauSac) {

        try {
            mauSacRepository.delete(mauSac);
            return "Xóa thành công!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Xóa thất bại";
        }
    }

    @Override
    public MauSac update(MauSac mauSac) {
        if (mauSacRepository.existsById(mauSac.getId())) {
            try {
                return mauSacRepository.save(mauSac);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;

    }

    @Override
    public MauSac findMauSacById(UUID id) {
        Optional<MauSac> ms = mauSacRepository.findById(id);
        if (ms.isPresent()) {
            return ms.get();
        }
        return null;
    }

    @Override
    public Page<MauSac> searchByFields(String fields, int page, int sizePage) {
        Pageable pageable = PageRequest.of(page - 1, sizePage);

        return mauSacRepository.searchByFields(fields, pageable);

    }

    @Override
    public MauSac findMauSacByMa(String ma) {
        Optional<MauSac> mauSacOptional = mauSacRepository.findByMa(ma);
        if (mauSacOptional.isPresent()) {
            return mauSacOptional.get();
        }
        return null;
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<MauSac> existingMauSac = mauSacRepository.findByMaAndIdNot(ma, id);
        if (existingMauSac.isPresent()) {
            return true;
        }
        return false;
    }
}
