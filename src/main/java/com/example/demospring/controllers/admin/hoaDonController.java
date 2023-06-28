package com.example.demospring.controllers.admin;

import com.example.demospring.models.entity.HoaDon;
import com.example.demospring.services.IHoaDonService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user/hoaDon")
public class hoaDonController {
    @Autowired
    private IHoaDonService hoaDonService;
//    Date currentDate = new Date(System.currentTimeMillis());
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    String dateString = dateFormat.format(currentDate);

    @GetMapping("/listHoaDon")
    public String getList(Model model, @RequestParam(defaultValue = "1000-01-01") String startDate, @RequestParam(defaultValue = "5000-01-01") String endDate, @RequestParam(defaultValue = "1") int tinhTrang, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String fields){
        String pattern = "yyyy-MM-dd"; // Định dạng của chuỗi ngày

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date dateStart = new Date();
        Date dateEnd = new Date();
        try {
            dateStart = dateFormat.parse(startDate); // Chuyển đổi chuỗi thành đối tượng Date
            dateEnd = dateFormat.parse(endDate); // Chuyển đổi chuỗi thành đối tượng Date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int pageSize = 5;
        Page<HoaDon> hoaDonPage = this.hoaDonService.searchHoaDonByFields(fields,tinhTrang,dateStart,dateEnd,page,pageSize);
        model.addAttribute("ds",hoaDonPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",hoaDonPage.getTotalPages());
        model.addAttribute("fields",fields);
        model.addAttribute("tinhTrang",tinhTrang);
        model.addAttribute("content","HoaDon/listHoaDon_view.jsp");
        return "layout";
    }
    @GetMapping("/xemHdct/{id}")
    public String getListHdct(Model model, @ModelAttribute("id") HoaDon hoaDon){
        model.addAttribute("totalAmount",this.hoaDonService.totalAmountOfHoaDon(hoaDon));
        model.addAttribute("tenKhachHang",hoaDon.getIdKH().getTen());
        model.addAttribute("ds",hoaDon.getListHDCT());
        model.addAttribute("hoadon",hoaDon);
        model.addAttribute("content","HoaDon/listHdct_view.jsp");
        return "layout";
    }

    @PostMapping("/updateHoaDon/{id}")
    public String updateHoaDon(Model model,@ModelAttribute("id") HoaDon hoaDon){
        this.hoaDonService.update(hoaDon);

        return "redirect:/user/hoaDon/listHoaDon";
    }
}
