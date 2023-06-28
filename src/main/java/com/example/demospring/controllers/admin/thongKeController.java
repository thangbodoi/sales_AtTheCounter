package com.example.demospring.controllers.admin;

import com.example.demospring.services.IthongKeDoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/thongKe")
public class thongKeController {
    @Autowired
    private IthongKeDoanhThuService ithongKeDoanhThuService;


    @GetMapping("/revenueByDay_view")
    public String revenueByDay(Model model ) {

//        String pattern = "yyyy-MM-dd"; // Định dạng của chuỗi ngày
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//        Date date1 = new Date();
//        try {
//            date1 = dateFormat.parse(date); // Chuyển đổi chuỗi thành đối tượng Date
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        List<Object[]> listThongKeTheoNgay = ithongKeDoanhThuService.doanhThuTheoNgay();
//        List<Object> listDoanhThu = new ArrayList<>();
//        for (Object[] doanhThu : listThongKeTheoNgay) {
//            Date date = (Date) doanhThu[0];
//        }
        model.addAttribute("ds", ithongKeDoanhThuService.doanhThuTheoNgay());;
        model.addAttribute("content", "ThongKe/revenueByDay.jsp");
        return "layout";
    }
    @GetMapping("/revenueByMonth_view")
    public String revenueByMonth(Model model ) {

        model.addAttribute("ds", ithongKeDoanhThuService.doanhThuTheoThang());;
        model.addAttribute("content", "ThongKe/revenueByMonth.jsp");
        return "layout";
    }
    @GetMapping("/revenueByYear_view")
    public String revenueByYear(Model model ) {


        model.addAttribute("ds", ithongKeDoanhThuService.doanhThuTheoNam());;
        model.addAttribute("content", "ThongKe/revenueByYear.jsp");
        return "layout";
    }
}
