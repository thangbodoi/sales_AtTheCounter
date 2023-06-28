package com.example.demospring.models.entity;

import com.example.demospring.utilities.ValidNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.IMessage;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chitietsp")
public class ChiTietSP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @DecimalMin(value = "0.0", inclusive = true, message = "Giá bán phải là số dương!")
    @NotNull
    @Column(name = "giaban")
    private BigDecimal giaBan;

    @DecimalMin(value = "0.0", inclusive = true, message = "Giá bán phải là số dương!")
    @NotNull
    @Column(name = "gianhap")
    private BigDecimal giaNhap;

    @NotBlank
    @Column(name = "mota")
    private String moTa;

    @NotNull
    @PositiveOrZero(message = "Năm BH phải là số nguyên >= 0")
    @Column(name = "nambh")
    private int namBH;

    @NotNull
    @PositiveOrZero(message = "Số lượng tồn phải là số nguyên dương")
    @Column(name = "soluongton")
    private int soLuongTon;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddongsp")
    private DongSP idDongSP;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmausac")
    private MauSac idMauSac;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idnsx")
    private NSX idNsx;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSP")
    private SanPham idSP;

    @OneToMany(mappedBy = "idChiTietSP", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGioHangCT;

    @OneToMany(mappedBy = "idChiTietSP", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;


}
