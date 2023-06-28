package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.SanPham;
import com.example.demospring.services.IDongSPService;
import com.example.demospring.services.ISanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/sanPham")
public class sanPhamComtroller {

    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int sizePage = 5;
        Page<SanPham> spPage = sanPhamService.searchByFields(fields, page, sizePage);
        model.addAttribute("ds", spPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", spPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","SanPham/index.jsp");
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") SanPham sanpham) {
        if (sanPhamService.delete(sanpham)) {
            redirectAttributes.addFlashAttribute("txtNotice", "Delete complete");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Delete failed");
        }
        return "redirect:/admin/sanPham/index";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("sanpham", new SanPham());
        model.addAttribute("content","SanPham/create.jsp");
        return "layout";
    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable("id") SanPham sanpham) {
        model.addAttribute("sanpham", sanpham);
        model.addAttribute("content","SanPham/update.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("sanpham") SanPham sanpham, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (sanPhamService.findSanPhamByMa(sanpham.getMa()) != null) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","SanPham/create.jsp");
            return "layout";
        }
        if (sanPhamService.create(sanpham) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Create complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Create failed");
        }
        return "redirect:/admin/sanPham/index";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("sanpham") SanPham sanpham, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (sanPhamService.isMaAndIdNot(sanpham.getMa(), sanpham.getId())) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","SanPham/update.jsp");
            return "layout";
        }
        if (sanPhamService.update(sanpham) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Update complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Update failed");
        }
        return "redirect:/admin/sanPham/index";
    }
}
