package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.ChucVu;
import com.example.demospring.services.IChucVuService;
import com.example.demospring.services.IMauSacService;
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
@RequestMapping("/admin/chucVu")
public class chucVuController {

    @Autowired
    private IChucVuService chucVuService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int pageSize = 5;

        Page<ChucVu> chucVuPage = chucVuService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", chucVuPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", chucVuPage.getTotalPages());
        model.addAttribute("content","ChucVu/index.jsp");
        model.addAttribute("fields", fields);
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable UUID id) {
        if (chucVuService.delete(chucVuService.findChucVuById(id))) {
            redirectAttributes.addFlashAttribute("txtNotice", "Xoa thanh cong!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Xoa that bai!");
        }
        return "redirect:/admin/chucVu/index";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("chucvu", new ChucVu());
        model.addAttribute("content","ChucVu/create.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("chucvu") ChucVu chucvu, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (chucVuService.findChucVuByMa(chucvu.getMa()) != null) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","ChucVu/create.jsp");
            return "layout";
        }
        chucVuService.create(chucvu);
        redirectAttributes.addFlashAttribute("txtNotice", "Them thanh cong");
        return "redirect:/admin/chucVu/index";

    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable UUID id) {
        model.addAttribute("chucvu", chucVuService.findChucVuById(id));
        model.addAttribute("content","ChucVu/update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("chucvu") ChucVu chucvu, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (this.chucVuService.isMaAndIdNot(chucvu.getMa(), chucvu.getId())) {
            model.addAttribute("errMa", "Ma nay da ton tai voi mau sac khac!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","ChucVu/update.jsp");
            return "layout";
        }

        this.chucVuService.update(chucvu);
        redirectAttributes.addFlashAttribute("txtNotice", "Update thanh cong!");
        return "redirect:/admin/chucVu/index";
    }
}
