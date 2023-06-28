//package com.example.demospring.services.serviceimpl;
//
//import com.example.demospring.models.entity.NhanVien;
//import com.example.demospring.repository.INhanVienRepository;
//import com.example.demospring.services.UserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class NhanVienDetailsService implements UserDetailsService {
//
//    @Autowired
//    private INhanVienRepository nhanVienRepository;
//
//    @Override
//    public UserDetails loadUserBySdt(String sdt) throws UsernameNotFoundException {
//        NhanVien nhanVien = nhanVienRepository.findBySdt(sdt);
//        if(nhanVien != null){
//            List<GrantedAuthority> authorityList = new ArrayList<>();
//            authorityList.add(new SimpleGrantedAuthority(nhanVien.getIdCV().getTen()));
//            return new User(nhanVien.getSdt(),nhanVien.getMatKhau(),authorityList);
//        }else{
//            throw new UsernameNotFoundException("Người dùng không tồn tại!");
//        }
//    }
//}
