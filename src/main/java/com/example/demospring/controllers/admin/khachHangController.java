package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.KhachHang;
import com.example.demospring.services.IKhachHangService;
import com.example.demospring.services.serviceimpl.HoaDonService;
import com.example.demospring.services.serviceimpl.KhachHangService;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jdk.jfr.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping("/admin/khachHang")
public class khachHangController {

    @Autowired
    private KhachHangService khachHangService;


    @GetMapping("/index")
    public String getKhachHangPage(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int pageSize = 5; //So luong tren moi trang
        Page<KhachHang> khachHangPage = khachHangService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", khachHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", khachHangPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content", "KhachHang/index.jsp");
        return "layout";
    }
//    @GetMapping("/index")
//    public String getList(Model model) {
//        model.addAttribute("ds", khachHangService.getAll());
//        return "KhachHang/index";
//    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("khachhang", new KhachHang());
        model.addAttribute("content", "KhachHang/create.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(Model model, @Validated @ModelAttribute("khachhang") KhachHang khachhang, BindingResult result) {
        boolean a = true;
        if (result.hasErrors()) {
            a = false;
        }
        if (khachHangService.findKhachHangByMa(khachhang.getMa()) != null) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = false;
        }
        if (a == false) {
            model.addAttribute("content", "KhachHang/create.jsp");
            return "layout";
        }
        khachHangService.add(khachhang);
        return "redirect:/admin/khachHang/index";

    }

    @PostMapping("/update")
    public String update(Model model, @Valid @ModelAttribute("khachhang") KhachHang khachHang, BindingResult result) {
        boolean a = true;
        if (result.hasErrors()) {
            a = false;
        }
        if (khachHangService.findByMaAndIdNot(khachHang.getMa(), khachHang.getId())) {
            a = false;
            model.addAttribute("errMa", "Mã này đã tồn tại với khách hàng khác!");
        }
        if (a == false) {
            model.addAttribute("content", "KhachHang/update.jsp");
            return "layout";
        }
        khachHangService.update(khachHang);
        return "redirect:/admin/khachHang/index";
    }

    @GetMapping("/update_view")
    public String update(Model model, @RequestParam UUID id) {
        model.addAttribute("khachhang", khachHangService.findKhachHangById(id));
        model.addAttribute("content", "KhachHang/update.jsp");
        return "layout";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam("id") UUID id) {
        model.addAttribute("notice", "Successful delete!");
        khachHangService.delete(khachHangService.findKhachHangById(id));
        return "redirect:/admin/khachHang/index";
    }
}
