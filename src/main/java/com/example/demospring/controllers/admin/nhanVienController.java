package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.ChucVu;
import com.example.demospring.models.entity.CuaHang;
import com.example.demospring.models.entity.NhanVien;
import com.example.demospring.services.IChucVuService;
import com.example.demospring.services.ICuaHangService;
import com.example.demospring.services.INhanVienService;
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
@RequestMapping("/admin/nhanVien")
public class nhanVienController {
    @Autowired
    private INhanVienService nhanVienService;

    @Autowired
    private IChucVuService chucVuService;

    @Autowired
    private ICuaHangService cuaHangService;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int pageSize = 5;//So luong tren moi trang
        Page<NhanVien> nhanVienPage = nhanVienService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content","NhanVien/index.jsp");
        return "layout";
    }

    @GetMapping("/create_view")
    public String create_view(Model model) {
        List<ChucVu> chucVuList = chucVuService.getList();
        List<CuaHang> cuaHangList = cuaHangService.getList();
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("chucVuList", chucVuList);
        model.addAttribute("cuaHangList", cuaHangList);
        model.addAttribute("content","NhanVien/create.jsp");
        return "layout";
    }

    @PostMapping("/create")
    public String create(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result) {
        boolean a = true;
        if (result.hasErrors()) {
            a = false;
        }
        if (nhanVienService.findNhanVienByMa(nhanVien.getMa()) != null) {
            model.addAttribute("errMa", "Mã nhân viên đã tồn tại!");
            a = false;

        }
        if (a == false) {
            List<ChucVu> chucVuList = chucVuService.getList();
            List<CuaHang> cuaHangList = cuaHangService.getList();
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("cuaHangList", cuaHangList);
            model.addAttribute("content","NhanVien/create.jsp");
            return "layout";
        }
        nhanVienService.create(nhanVien);
        redirectAttributes.addFlashAttribute("txtNotice", "Them thanh cong");
        return "redirect:/admin/nhanVien/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable UUID id) {
        redirectAttributes.addFlashAttribute("txtNotice", nhanVienService.delete(nhanVienService.findNhanVienById(id)));
        return "redirect:/admin/nhanVien/index";

    }

    @GetMapping("/update_view/{id}")
    public String update_view(Model model, @PathVariable UUID id) {
        model.addAttribute("nhanvien", this.nhanVienService.findNhanVienById(id));
        List<ChucVu> chucVuList = chucVuService.getList();
        List<CuaHang> cuaHangList = cuaHangService.getList();
        model.addAttribute("chucVuList", chucVuList);
        model.addAttribute("cuaHangList", cuaHangList);
        model.addAttribute("content","NhanVien/update.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(RedirectAttributes redirectAttributes, Model model, @Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result) {
        boolean a = true;
        if (result.hasErrors()) {
            a = false;
        }
        if (this.nhanVienService.isMaAndIdNot(nhanVien.getMa(), nhanVien.getId())) {
            model.addAttribute("errMa", "Mã này đã tồn tại với nhan vien khác!");
            a = false;
        }
        if (a == false) {
            List<ChucVu> chucVuList = chucVuService.getList();
            List<CuaHang> cuaHangList = cuaHangService.getList();
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("cuaHangList", cuaHangList);
            model.addAttribute("content","NhanVien/update.jsp");
            return "layout";
        }
        this.nhanVienService.update(nhanVien);
        redirectAttributes.addFlashAttribute("txtNotice", "Update thanh cong");
        return "redirect:/admin/nhanVien/index";

    }
}
