package com.example.demospring.models.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
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
@Table(name = "khachhang"/*, uniqueConstraints = {@UniqueConstraint(columnNames = {"ma"})}*/)
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Column(name = "ma", length = 20, unique = true)
    private String ma;

    @NotBlank
    @Column(name = "ten", length = 30)
    private String ten;

    @NotBlank
    @Column(name = "tendem", length = 30)
    private String tenDem;


    @NotBlank
    @Column(name = "ho", length = 20)
    private String ho;

    @NotNull(message = "Mời bạn chọn ngày sinh!")
    @Past(message = "Ngày sinh phải là một ngày trong quá khứ!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaysinh")
    private Date ngaySinh;


    @NotBlank
    @Column(name = "sdt", length = 30)
    private String sdt;

    @NotBlank
    @Column(name = "diachi", length = 100)
    private String diaChi;

    @NotBlank
    @Column(name = "thanhpho", length = 50)
    private String thanhPho;

    @NotBlank
    @Column(name = "quocgia", length = 50)
    private String quocGia;

    @NotBlank
    @Column(name = "matkhau")
    private String matKhau;

    @OneToOne(mappedBy = "idKH", fetch = FetchType.LAZY)
    private GioHang listGioHang;

    @OneToMany(mappedBy = "idKH", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;


}
