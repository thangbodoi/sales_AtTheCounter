package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.CuaHang;
import com.example.demospring.services.ICuaHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/admin/cuaHang")
public class cuaHangController {
    @Autowired
    private ICuaHangService cuaHangService;


    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam( defaultValue = "") String fields) {
        int pageSize = 5;
        Page<CuaHang> cuaHangPage = cuaHangService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", cuaHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", cuaHangPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","CuaHang/index.jsp");
        return "layout";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("cuahang", new CuaHang());
        model.addAttribute("content","CuaHang/create.jsp");
        return "layout";
    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable UUID id) {
        model.addAttribute("cuahang", cuaHangService.findCuaHangById(id));
        model.addAttribute("content","CuaHang/update.jsp");
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable UUID id) {
        if (cuaHangService.delete(cuaHangService.findCuaHangById(id))) {
            redirectAttributes.addFlashAttribute("txtNotice", "Xoa thanh cong!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Xoa that bai!");
        }
        return "redirect:/admin/cuaHang/index";
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("cuahang") CuaHang cuahang, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (cuaHangService.isMaAndIdNot(cuahang.getMa(), cuahang.getId())) {
            a = true;
            model.addAttribute("errMa", "This Ma already exists!");
        }
        if (a) {
            model.addAttribute("content","CuaHang/update.jsp");
            return "layout";
        }
        CuaHang cuaHang = cuaHangService.update(cuahang);
        if (cuaHang != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Update complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Update failed!");
        }
        return "redirect:/admin/cuaHang/index";

    }

    @PostMapping("/create")
    public String create(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("cuahang") CuaHang cuahang, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (cuaHangService.findCuaHangByMa(cuahang.getMa()) != null) {
            model.addAttribute("errMa", "This Ma already exists");
            a = true;
        }
        if (a) {
            model.addAttribute("content","CuaHang/create.jsp");
            return "layout";
        }
        if (cuaHangService.create(cuahang) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Create complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Create failed");
        }
        return "redirect:/admin/cuaHang/index";
    }
}
