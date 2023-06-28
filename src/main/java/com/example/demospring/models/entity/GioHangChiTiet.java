package com.example.demospring.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "giohangchitiet")
@IdClass(GioHangChiTietId.class)
public class GioHangChiTiet implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idgiohang", nullable = false)
    private GioHang idGioHang;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idchitietsp", nullable = false)
    private ChiTietSP idChiTietSP;

    @NotNull(message = "Không được để trống số lượng!")
    @PositiveOrZero(message = "Số lượng tồn phải là số nguyên dương")
    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "dongiakhigiam")
    private BigDecimal donGiaKhiGiam;

}
