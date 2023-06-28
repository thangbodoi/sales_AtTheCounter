package com.example.demospring.services.serviceimpl;

import com.example.demospring.models.entity.NhanVien;
import com.example.demospring.repository.INhanVienRepository;
import com.example.demospring.services.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienService implements INhanVienService {

    @Autowired
    private INhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getList() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void create(NhanVien nhanVien) {
        nhanVien.setId(null);
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public String delete(NhanVien nhanVien) {
        try {
            nhanVienRepository.delete(nhanVien);
            return "Delete complete!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete failed";
        }
    }

    @Override
    public NhanVien update(NhanVien nhanVien) {
        UUID id = nhanVien.getId();
        if (nhanVienRepository.existsById(id)) {
            return nhanVienRepository.save(nhanVien);
        }
        return null;
    }

    @Override
    public NhanVien findNhanVienById(UUID id) {
        Optional<NhanVien> nhanVien = nhanVienRepository.findById(id);
        if (nhanVien.isPresent()) {
            return nhanVien.get();

        }
        return null;
    }

    @Override
    public Page<NhanVien> searchByFields(String fields, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return nhanVienRepository.searchByFields(fields, pageable);
    }

    @Override
    public NhanVien findNhanVienByMa(String ma) {
        Optional<NhanVien> nhanVienOptional = nhanVienRepository.findByMa(ma);
        if (nhanVienOptional.isPresent()) {
            return nhanVienOptional.get();
        }
        return null;
    }

    @Override
    public boolean isMaAndIdNot(String ma, UUID id) {
        Optional<NhanVien> existingNhanVien = nhanVienRepository.findByMaAndIdNot(ma, id);
        if (existingNhanVien.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<NhanVien> getListNhanVienWithChucVu(String tenCv) {
        return  this.nhanVienRepository.findAllByCv(tenCv);
    }

    @Override
    public NhanVien findNhanVienBySdt(String sdt) {
       Optional<NhanVien>  nhanVien = this.nhanVienRepository.findBySdt(sdt);
       if(nhanVien.isPresent()){
           return nhanVien.get();
       }
        return null;
    }


}
