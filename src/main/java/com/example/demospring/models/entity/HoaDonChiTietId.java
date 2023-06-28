package com.example.demospring.models.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class HoaDonChiTietId implements Serializable {
    private HoaDon idHoaDon;
    private ChiTietSP idChiTietSP;

}
