package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.*;
import com.example.demospring.services.*;
import com.example.demospring.utilities.layThongTinDangNhap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Scope;
import java.util.*;

@Controller
@SessionAttributes({"idGioHang", "idCtsp"})
@RequestMapping("/user/purchase")
public class muaBanController {

    @Autowired
    private layThongTinDangNhap layThongTinDangNhap;

    @Autowired
    private IGioHangService gioHangService;

    @Autowired
    private IPurchaseService iPurchaseService;

    @Autowired
    private IChiTietSanPhamService iChiTietSanPhamService;

    @Autowired
    private IHoaDonService iHoaDonService;

    @Autowired
    private INhanVienService iNhanVienService;



    @GetMapping("danhSachGioHang")
    public String listGioHang(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {

        int sizePage = 5;
        Page<GioHang> gioHangPage = gioHangService.searchByFields(fields, page, sizePage);
        model.addAttribute("ds", gioHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", gioHangPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content", "MuaBan/danhSachGioHang.jsp");
        return "layout";
    }

    @GetMapping("listGhct/{id}")
    public String listGhct(Model model, @PathVariable("id") GioHang gioHang, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int sizePage = 5;
        Page<GioHangChiTiet> gioHangCtPage = iPurchaseService.getListGhctOfGioHang(gioHang.getId(), fields, page, sizePage);
        model.addAttribute("idGioHang", gioHang.getId());
        model.addAttribute("ds", gioHangCtPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", gioHangCtPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content", "MuaBan/listGhctOfGioHang.jsp");
        return "layout";
    }

    @GetMapping("addGhct_View/{id}")
    public String addGhct_View(Model model, @PathVariable("id") ChiTietSP chiTietSP) {
        model.addAttribute("idCtsp", chiTietSP.getId());
        model.addAttribute("ghct",new GioHangChiTiet());
        model.addAttribute("content", "MuaBan/writeNumberView.jsp");
        return "layout";
    }

    @GetMapping("/deleteGhct/{id}")
    public String deleteGhct(Model model,@PathVariable("id") ChiTietSP chiTietSP,@ModelAttribute("idGioHang") GioHang gioHang){
        GioHangChiTiet gioHangChiTiet = iPurchaseService.findGioHangCtById(gioHang,chiTietSP);
        chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() + gioHangChiTiet.getSoLuong());
        this.iChiTietSanPhamService.update(chiTietSP);
        this.iPurchaseService.deleteGhct(gioHangChiTiet);
        return "redirect:/user/purchase/listGhct/"+gioHang.getId();
    }
    @GetMapping("/updateGhct_view/{id}")
    public String updateGhct_view(Model model,@PathVariable("id") ChiTietSP chiTietSP,@ModelAttribute("idGioHang") GioHang gioHang){
        GioHangChiTiet gioHangChiTiet = iPurchaseService.findGioHangCtById(gioHang,chiTietSP);
        model.addAttribute("ghct",gioHangChiTiet);
        model.addAttribute("content", "MuaBan/updateGhct.jsp");
        return "layout";
    }
    @PostMapping("/updateGhct/{id}")
    public String updateGhct(Model model,@PathVariable("id") ChiTietSP ctsp,@ModelAttribute("idGioHang") GioHang gioHang,@Valid @ModelAttribute("ghct") GioHangChiTiet gioHangChiTiet,BindingResult result){
        boolean a = false;
        if(result.hasErrors()){
            a = true;
        }
        if(gioHangChiTiet.getSoLuong() == 0){
            model.addAttribute("txtSoLuong","Số lượng phải lớn hơn 0");
            a = true;
        }
        if(a){
            gioHangChiTiet.setIdGioHang(gioHang);
            gioHangChiTiet.setIdChiTietSP(ctsp);
            model.addAttribute("ghct",gioHangChiTiet);
            model.addAttribute("content", "MuaBan/updateGhct.jsp");
            return "layout";
        }
        GioHangChiTiet gioHangChiTiet1 = iPurchaseService.findGioHangCtById(gioHang, ctsp);
        if(gioHangChiTiet.getSoLuong() == gioHangChiTiet1.getSoLuong()){
            return "redirect:/user/purchase/listGhct/"+gioHang.getId();
        }

            int soLuongMoi = gioHangChiTiet.getSoLuong();
            int soLuongCu = gioHangChiTiet1.getSoLuong();
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() + (soLuongCu - soLuongMoi));
            if((ctsp.getSoLuongTon() + iChiTietSanPhamService.findById(ctsp.getId()).getSoLuongTon())<0){
                gioHangChiTiet.setIdGioHang(gioHang);
                gioHangChiTiet.setIdChiTietSP(ctsp);
                model.addAttribute("ghct",gioHangChiTiet);
                model.addAttribute("txtSoLuong","Số lượng trong kho không đủ");
                model.addAttribute("content", "MuaBan/updateGhct.jsp");
                return "layout";
            }

            iChiTietSanPhamService.update(ctsp);
            gioHangChiTiet.setIdChiTietSP(ctsp);
            gioHangChiTiet.setIdGioHang(gioHang);
            gioHangChiTiet.setDonGia(ctsp.getGiaBan());
            this.iPurchaseService.addOrUpdateGhct(gioHangChiTiet);

            return "redirect:/user/purchase/listGhct/"+gioHang.getId();


    }
    @PostMapping("/addGhct")
    public String addGhct(Model model, @ModelAttribute("idGioHang") GioHang gioHang, @ModelAttribute("idCtsp") ChiTietSP chiTietSP, @Valid @ModelAttribute("ghct") GioHangChiTiet gioHangChiTiet, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if(chiTietSP.getSoLuongTon() < gioHangChiTiet.getSoLuong()){
            model.addAttribute("txtSoLuong","Số lượng trong kho không đủ");
            a = true;
        }
        if(gioHangChiTiet.getSoLuong() == 0){
            return "redirect:/user/purchase/listGhct/"+gioHang.getId();
        }
        if(a){
            model.addAttribute("content", "MuaBan/writeNumberView.jsp");
            return "layout";
        }
        gioHangChiTiet.setIdChiTietSP(chiTietSP);
        gioHangChiTiet.setIdGioHang(gioHang);
        gioHangChiTiet.setDonGia(chiTietSP.getGiaBan());
        chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() - gioHangChiTiet.getSoLuong());
        GioHangChiTiet gioHangChiTiet1 = iPurchaseService.findGioHangCtById(gioHangChiTiet.getIdGioHang(), gioHangChiTiet.getIdChiTietSP());
        if(gioHangChiTiet1 != null){
            gioHangChiTiet1.setSoLuong(gioHangChiTiet.getSoLuong() + gioHangChiTiet1.getSoLuong());
            this.iPurchaseService.addOrUpdateGhct(gioHangChiTiet1);
        }else{
            this.iPurchaseService.addOrUpdateGhct(gioHangChiTiet);
        }
        this.iChiTietSanPhamService.update(chiTietSP);
        return "redirect:/user/purchase/listGhct/"+gioHang.getId();
    }

    @GetMapping("listCtsp")
    public String listCtsp(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields) {
        int pageSize = 5;
        Page<ChiTietSP> chiTietSPPage = iChiTietSanPhamService.searchByFields(fields, page, pageSize);
        model.addAttribute("ds", chiTietSPPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", chiTietSPPage.getTotalPages());
        model.addAttribute("fields", fields);
        model.addAttribute("content", "MuaBan/listCtsp.jsp");
        return "layout";
    }


    @GetMapping("createGioHang_view")
    public String addGioHang_view(Model model) {
        model.addAttribute("giohang", new GioHang());
        model.addAttribute("listKh", iPurchaseService.findKhachHangNotInGioHang());
        model.addAttribute("content", "MuaBan/addGioHang.jsp");
        return "layout";
    }

    @PostMapping("/createGioHang")
    public String createGioHang(Model model, @Valid @ModelAttribute("giohang") GioHang gioHang, BindingResult result) {
        boolean a = false;
        if (result.hasErrors()) {
            a = true;
        }
        if (gioHangService.findGioHangByMa(gioHang.getMa()) != null) {
            model.addAttribute("errMa", "Ma gio hang nay da ton tai!");
            a = true;
        }
        if (a) {
            model.addAttribute("listKh", iPurchaseService.findKhachHangNotInGioHang());
            model.addAttribute("content", "MuaBan/addGioHang.jsp");
            return "layout";
        }
        gioHang.setIdNV(layThongTinDangNhap.nhanVien());
        gioHang.setNgayTao(new Date(System.currentTimeMillis()));
        gioHangService.create(gioHang);
        return "redirect:/user/purchase/danhSachGioHang";

    }
    //Hóa đơn

    @GetMapping("/addHoaDon")
    public String addHoaDon(Model model,@ModelAttribute("idGioHang") GioHang gioHang){
        if(gioHang.getListGioHangChiTiet().isEmpty()){
            return "redirect:/user/purchase/listGhct/"+gioHang.getId();
        }

        HoaDon hd = new HoaDon();
        hd.setIdNV(layThongTinDangNhap.nhanVien());
        hd.setIdKH(gioHang.getIdKH());
        hd.setMa(String.valueOf(iHoaDonService.coutnHoaDon() + 1));
        HoaDon hd1 =  this.iHoaDonService.create(hd);
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        for (GioHangChiTiet gioHangChiTiet: gioHang.getListGioHangChiTiet()
             ) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdHoaDon(hd1);
            hoaDonChiTiet.setIdChiTietSP(gioHangChiTiet.getIdChiTietSP());
            hoaDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            listHDCT.add(hoaDonChiTiet);
        }
        iPurchaseService.saveListHdct(listHDCT);

        iPurchaseService.deleteListGhct(gioHang.getListGioHangChiTiet());
        model.addAttribute("totalAmount",this.iHoaDonService.totalAmountOfHoaDon(hd1));
        model.addAttribute("tenKhachHang",gioHang.getIdKH().getTen());
        model.addAttribute("ds",gioHang.getListGioHangChiTiet());
        model.addAttribute("hoadon",hd1);
        model.addAttribute("content", "MuaBan/addHoaDon.jsp");
        return "layout";
    }
    @PostMapping("/updateHoaDon/{id}")
    public String updateHoaDon(Model model,@ModelAttribute("idGioHang") GioHang gioHang,@ModelAttribute("hoadon") HoaDon hoaDon){
        hoaDon.setIdNV(layThongTinDangNhap.nhanVien());
        hoaDon.setIdKH(gioHang.getIdKH());
        this.iHoaDonService.update(hoaDon);
        return "redirect:/user/purchase/listGhct/"+gioHang.getId();
    }
}
