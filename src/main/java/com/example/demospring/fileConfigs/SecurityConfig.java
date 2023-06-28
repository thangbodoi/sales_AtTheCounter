package com.example.demospring.fileConfigs;

import com.example.demospring.models.entity.NhanVien;
import com.example.demospring.services.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig implements WebMvcConfigurer {
    @Autowired
    private INhanVienService nhanVienService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .logout()
                .logoutUrl("/logout") // Đường dẫn xử lý yêu cầu đăng xuất
                .logoutSuccessUrl("/user/purchase/danhSachGioHang") // Đường dẫn sau khi đăng xuất thành công
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) ->
                        {
                            response.sendRedirect("/user/purchase/danhSachGioHang");
                        }
                )
        ;

        // @formatter:on
        return http.build();
    }


    // @formatter:off
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        String tenUser = "User";
        String tenAdmin = "Admin";

        List<NhanVien> userList = nhanVienService.getListNhanVienWithChucVu(tenUser);
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (NhanVien nv : userList) {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(nv.getSdt())
                    .password(nv.getMatKhau())
                    .roles("USER")
                    .build();
            userDetailsList.add(user);
        }

        List<NhanVien> adminList = nhanVienService.getListNhanVienWithChucVu(tenAdmin);
        for (NhanVien nv : adminList) {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(nv.getSdt())
                    .password(nv.getMatKhau())
                    .roles("ADMIN")
                    .build();
            userDetailsList.add(user);
        }

        return new InMemoryUserDetailsManager(userDetailsList);
    }
    // @formatter:on


}
