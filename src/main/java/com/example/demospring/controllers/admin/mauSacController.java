package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.MauSac;
import com.example.demospring.services.IMauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/mauSac")
public class mauSacController {

    @Autowired
    private IMauSacService mauSacService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam( defaultValue = "") String fields) {
        int pageSize = 5;

        Page<MauSac> mauSacPage = mauSacService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", mauSacPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", mauSacPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","MauSac/index.jsp");
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable UUID id) {
        redirectAttributes.addFlashAttribute("txtNotice", mauSacService.delete(mauSacService.findMauSacById(id)));
        return "redirect:/admin/mauSac/index";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("mausac", new MauSac());
        model.addAttribute("content","MauSac/create.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("mausac") MauSac mausac, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (mauSacService.findMauSacByMa(mausac.getMa()) != null) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","MauSac/create.jsp");
            return "layout";
        }
        mauSacService.create(mausac);
        redirectAttributes.addFlashAttribute("txtNotice", "Them thanh cong");
        return "redirect:/admin/mauSac/index";

    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable UUID id) {
        model.addAttribute("mausac", mauSacService.findMauSacById(id));
        model.addAttribute("content","MauSac/update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("mausac") MauSac mausac, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (this.mauSacService.isMaAndIdNot(mausac.getMa(), mausac.getId())) {
            model.addAttribute("errMa", "Ma nay da ton tai voi mau sac khac!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","MauSac/update.jsp");
            return "layout";
        }

        this.mauSacService.update(mausac);
        redirectAttributes.addFlashAttribute("txtNotice", "Update thanh cong!");
        return "redirect:/admin/mauSac/index";
    }
}
