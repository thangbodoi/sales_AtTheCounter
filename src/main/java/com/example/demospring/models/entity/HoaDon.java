package com.example.demospring.models.entity;

import jakarta.persistence.*;
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
@Table(name = "hoadon")
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma", length = 20)
    private String ma;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaytao")
    private Date ngayTao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;

    @Column(name = "ngayship")
    private Date ngayShip;

    @Column(name = "ngaynhan")
    private Date ngayNhan;

    @Column(name = "tinhtrang")
    private int tinhTrang;

    @Column(name = "tennguoinhan", length = 50)
    private String tenNguoiNhan;

    @Column(name = "diachi", length = 100)
    private String diaChhi;

    @Column(name = "sdt", length = 30)
    private String sdt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKH")
    private KhachHang idKH;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNV")
    private NhanVien idNV;

    @OneToMany(mappedBy = "idHoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

}
