package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.ChiTietSP;
import com.example.demospring.services.*;
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
@RequestMapping("/admin/chiTietSanPham")
public class ctspController {

    @Autowired
    private IChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private IDongSPService dongSPService;

    @Autowired
    private IMauSacService mauSacService;

    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private INsxService nsxService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int pageSize = 5;
        Page<ChiTietSP> chiTietSPPage = chiTietSanPhamService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", chiTietSPPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", chiTietSPPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","ChiTietSP/index.jsp");
        return "layout";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("ctsp", new ChiTietSP());
        model.addAttribute("listNsx", nsxService.getList());
        model.addAttribute("listDsp", dongSPService.getList());
        model.addAttribute("listMauSac", mauSacService.getList());
        model.addAttribute("listSp", sanPhamService.getList());
        model.addAttribute("content","ChiTietSP/create.jsp");
        return "layout";
    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable("id") ChiTietSP chiTietSP) {
        model.addAttribute("ctsp", chiTietSP);
        model.addAttribute("listNsx", nsxService.getList());
        model.addAttribute("listDsp", dongSPService.getList());
        model.addAttribute("listMauSac", mauSacService.getList());
        model.addAttribute("listSp", sanPhamService.getList());
        model.addAttribute("content","ChiTietSP/update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("ctsp") ChiTietSP chiTietSP, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("listNsx", nsxService.getList());
            model.addAttribute("listDsp", dongSPService.getList());
            model.addAttribute("listMauSac", mauSacService.getList());
            model.addAttribute("listSp", sanPhamService.getList());
            model.addAttribute("content","ChiTietSP/update.jsp");
            return "layout";
        }
        ChiTietSP chiTietSP1 = chiTietSanPhamService.update(chiTietSP);
        if (chiTietSP1 != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Update complete!");
        }
        return "redirect:/admin/chiTietSanPham/index";

    }

    @PostMapping("create")
    public String create(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("ctsp") ChiTietSP chiTietSP, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("listNsx", nsxService.getList());
            model.addAttribute("listDsp", dongSPService.getList());
            model.addAttribute("listMauSac", mauSacService.getList());
            model.addAttribute("listSp", sanPhamService.getList());
            model.addAttribute("content","ChiTietSP/create.jsp");
            return "layout";

        }
        ChiTietSP ctsp = chiTietSanPhamService.create(chiTietSP);
        if (ctsp != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Create complete!");
        }
        return "redirect:/admin/chiTietSanPham/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable UUID id) {
        if (chiTietSanPhamService.delete(chiTietSanPhamService.findById(id))) {
            redirectAttributes.addFlashAttribute("txtNotice", "Xoa thanh cong!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Xoa that bai!");
        }
        return "redirect:/admin/chiTietSanPham/index";
    }

}
