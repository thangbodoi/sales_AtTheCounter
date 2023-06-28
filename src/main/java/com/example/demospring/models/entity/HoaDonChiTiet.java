package com.example.demospring.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hoadonchitiet")
@IdClass(HoaDonChiTietId.class)
public class HoaDonChiTiet implements Serializable {
    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idhoadon")
    private HoaDon idHoaDon;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idchitietsp")
    private ChiTietSP idChiTietSP;

}
