package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.DongSP;
import com.example.demospring.services.IDongSPService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/dongSp")
public class dongSpController {

    @Autowired
    private IDongSPService dongSPService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int sizePage = 5;
        Page<DongSP> spPage = dongSPService.searchByFields(fields, page, sizePage);
        model.addAttribute("ds", spPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", spPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","DongSP/index.jsp");
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") DongSP dongSP) {
        if (dongSPService.delete(dongSP)) {
            redirectAttributes.addFlashAttribute("txtNotice", "Delete complete");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Delete failed");
        }
        return "redirect:/admin/dongSp/index";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("dongsp", new DongSP());
        model.addAttribute("content","DongSP/create.jsp");
        return "layout";
    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable("id") DongSP dongSP) {
        model.addAttribute("dongsp", dongSP);
        model.addAttribute("content","DongSP/update.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("dongsp") DongSP dongSP, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (dongSPService.findDongSPByMa(dongSP.getMa()) != null) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","DongSP/create.jsp");
            return "layout";
        }
        if (dongSPService.create(dongSP) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Create complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Create failed");
        }
        return "redirect:/admin/dongSp/index";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("dongsp") DongSP dongSP, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (dongSPService.isMaAndIdNot(dongSP.getMa(), dongSP.getId())) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","DongSP/update.jsp");
            return "layout";
        }
        if (dongSPService.update(dongSP) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Update complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Update failed");
        }
        return "redirect:/admin/dongSp/index";
    }
}
