package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.NSX;
import com.example.demospring.services.IDongSPService;
import com.example.demospring.services.INsxService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/nsx")
public class nsxController {

    @Autowired
    private INsxService nsxService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int sizePage = 5;
        Page<NSX> spPage = nsxService.searchByFields(fields, page, sizePage);
        model.addAttribute("ds", spPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", spPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","NSX/index.jsp");
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") NSX nsx) {
        if (nsxService.delete(nsx)) {
            redirectAttributes.addFlashAttribute("txtNotice", "Delete complete");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Delete failed");
        }
        return "redirect:/admin/nsx/index";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        model.addAttribute("nsx", new NSX());
        model.addAttribute("content","NSX/create.jsp");
        return "layout";
    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable("id") NSX nsx) {
        model.addAttribute("nsx", nsx);
        model.addAttribute("content","NSX/update.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("nsx") NSX nsx, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (nsxService.findNsxByMa(nsx.getMa()) != null) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","NSX/create.jsp");
            return "layout";
        }
        if (nsxService.create(nsx) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Create complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Create failed");
        }
        return "redirect:/admin/nsx/index";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("nsx") NSX nsx, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (nsxService.isMaAndIdNot(nsx.getMa(), nsx.getId())) {
            model.addAttribute("errMa", "Ma nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("content","NSX/update.jsp");
            return "layout";
        }
        if (nsxService.update(nsx) != null) {
            redirectAttributes.addFlashAttribute("txtNotice", "Update complete!");
        } else {
            redirectAttributes.addFlashAttribute("txtNotice", "Update failed");
        }
        return "redirect:/admin/nsx/index";
    }
}
