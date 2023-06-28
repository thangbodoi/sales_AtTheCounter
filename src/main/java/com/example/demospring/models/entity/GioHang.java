package com.example.demospring.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "giohang")
public class GioHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Column(name = "ma", length = 20)
    private String ma;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;

    @NotBlank
    @Column(name = "tennguoinhan", length = 100)
    private String tenNguoiNhan;

    @NotBlank
    @Column(name = "diachi", length = 100)
    private String diaChi;

    @NotBlank
    @Pattern(regexp = "(09|03|07|08|05)\\d{8}", message = "Wrong format!")
    @Column(name = "sdt", length = 20)
    private String sdt;

    @Column(name = "tinhtrang")
    private int tinhTrang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNV")
    private NhanVien idNV;

    @NotNull(message = "Mời bạn chọn khách hàng để thêm giỏ hàng!")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKH")
    private KhachHang idKH;

    @OneToMany(mappedBy = "idGioHang", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGioHangChiTiet;


}
