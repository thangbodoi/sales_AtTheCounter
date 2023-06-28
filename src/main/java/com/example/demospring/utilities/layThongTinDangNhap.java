package com.example.demospring.utilities;

import com.example.demospring.models.entity.NhanVien;
import com.example.demospring.services.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class layThongTinDangNhap {

    @Autowired
    private INhanVienService nhanVienService;

    public NhanVien nhanVien(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            return this.nhanVienService.findNhanVienBySdt(username);
        }
        return null;

    }
}

