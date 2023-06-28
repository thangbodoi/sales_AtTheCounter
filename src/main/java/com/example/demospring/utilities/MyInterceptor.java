package com.example.demospring.utilities;

import com.example.demospring.models.entity.NhanVien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Xử lý trước khi Controller xử lý yêu cầu
        HttpSession session = request.getSession();
        NhanVien nhanVien = (NhanVien) session.getAttribute("nhanVien");

        if(nhanVien == null){
            response.sendRedirect("/homeLogin/login_view");
            System.out.println("lõi hẻeresadbagdvagevd");
            return false; // Trả về true để cho phép tiếp tục xử lý yêu cầu, hoặc false để ngăn chặn xử lý yêu cầu
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Xử lý sau khi Controller xử lý yêu cầu, trước khi trả về phản hồi cho client
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Xử lý sau khi đã hoàn tất xử lý yêu cầu, sau khi đã trả về phản hồi cho client
    }
}
