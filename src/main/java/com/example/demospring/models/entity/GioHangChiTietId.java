package com.example.demospring.models.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class GioHangChiTietId implements Serializable {
    private GioHang idGioHang;
    private ChiTietSP idChiTietSP;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GioHangChiTietId)) return false;
        GioHangChiTietId that = (GioHangChiTietId) o;
        return getIdGioHang().equals(that.getIdGioHang()) && getIdChiTietSP().equals(that.getIdChiTietSP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdGioHang(), getIdChiTietSP());
    }
}
