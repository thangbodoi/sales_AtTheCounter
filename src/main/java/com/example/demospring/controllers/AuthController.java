//package com.example.demospring.controllers;
//
//import com.example.demospring.models.entity.NhanVien;
//import com.example.demospring.repository.INhanVienRepository;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/homeLogin")
//public class AuthController {
//
//    @Autowired
//    private INhanVienRepository nhanVienRepository;
//
//
//    @PostMapping("/login")
//    public String login(@RequestParam("sdt") String username, @RequestParam("password") String password, Model model, HttpServletRequest request) {
//        int dem = 0;
//
//        NhanVien nhanVien = nhanVienRepository.findBySdt(username);
//        if(nhanVien==null){
//            model.addAttribute("errPassword", "Incorrect account or password");
//            model.addAttribute("content","Login/login.jsp");
//            return "layout";
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("nhanVien", nhanVien);
//        if (!username.equals(nhanVien.getSdt()) || !password.equals(nhanVien.getMatKhau())) {
//            model.addAttribute("errPassword", "Incorrect account or password");
//            dem++;
//        }
//        if (dem != 0) {
//            model.addAttribute("content","Login/login.jsp");
//            return "layout";
//        } else {
//            return "redirect:/purchase/danhSachGioHang";
//        }
//
//    }
////
//    @GetMapping ("/login_view")
//    public String login(Model model) {
//        model.addAttribute("content", "Login/login.jsp");
//        return "layout";
//    }
//}
