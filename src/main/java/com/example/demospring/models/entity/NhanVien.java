package com.example.demospring.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Column(name = "ma", length = 20)
    private String ma;

    @NotBlank
    @Column(name = "ten", length = 30)
    private String ten;

    @NotBlank
    @Column(name = "tendem", length = 30)
    private String tenDem;

    @NotBlank
    @Column(name = "ho", length = 30)
    private String ho;

    @NotBlank
    @Column(name = "gioitinh", length = 10)
    private String gioiTinh;

    @NotNull(message = "Mời bạn chọn ngày sinh!")
    @Past(message = "Ngày sinh phải là một ngày trong quá khứ!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @NotBlank
    @Pattern(regexp = "(09|03|07|08|05)\\d{8}", message = "Wrong format!")
    @Column(name = "sdt", length = 30)
    private String sdt;

    @NotBlank
    @Column(name = "matkhau")
    private String matKhau;

    @NotBlank
    @Column(name = "diachi")
    private String diaChi;

    @NotNull
    @Column(name = "trangthai")
    private int trangThai;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCH")
    private CuaHang idCH;

    @OneToMany(mappedBy = "idNV", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;

    @OneToMany(mappedBy = "idNV", fetch = FetchType.LAZY)
    private List<GioHang> listGioHang;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCV")
    private ChucVu idCV;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idguibc")
    private NhanVien idGuiBC;

    @OneToMany(mappedBy = "idGuiBC", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;
}
