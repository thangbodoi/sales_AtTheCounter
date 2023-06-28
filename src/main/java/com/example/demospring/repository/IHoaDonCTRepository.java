package com.example.demospring.repository;

import com.example.demospring.models.entity.*;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IHoaDonCTRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {

    Optional findByIdHoaDonAndIdChiTietSP(HoaDon idHoaDon, ChiTietSP idChiTietSP);

    @Query("select sum(hdct.donGia * hdct.soLuong) from HoaDonChiTiet hdct where hdct.idHoaDon = :hoaDon")
    double totalAmountOf(HoaDon hoaDon);

    @Query("SELECT h.ngayTao, SUM(hct.soLuong * hct.donGia) AS doanhThu FROM HoaDon h JOIN h.listHDCT hct GROUP BY h.ngayTao")
    List<Object[]> doanhThuTheoNgay();

    @Query("SELECT SUM(hct.soLuong * hct.donGia) FROM HoaDon h JOIN h.listHDCT hct WHERE FUNCTION('MONTH', h.ngayTao) = FUNCTION('MONTH', :month) AND FUNCTION('YEAR', h.ngayTao) = FUNCTION('YEAR', :year) GROUP BY FUNCTION('MONTH', h.ngayTao), FUNCTION('YEAR', h.ngayTao)")
    BigDecimal searchDoanhThuTheoThang(@Param("month") int month,@Param("year") int year);

    @Query("select function('MONTH',hd.ngayTao),function('YEAR',hd.ngayTao) ,SUM(hdct.soLuong * hdct.donGia) as doanhThu from HoaDon hd join hd.listHDCT hdct GROUP BY function('MONTH',hd.ngayTao),function('YEAR',hd.ngayTao) ")
    List<Object[]> revenueByMonth();

    @Query("select function('YEAR',hd.ngayTao) ,SUM(hdct.soLuong * hdct.donGia) as doanhThu from HoaDon hd join hd.listHDCT hdct GROUP BY function('YEAR',hd.ngayTao) ")
    List<Object[]> revenueByYear();

    @Query("SELECT SUM(hct.soLuong * hct.donGia) FROM HoaDon h JOIN h.listHDCT hct WHERE FUNCTION('YEAR', h.ngayTao) = FUNCTION('YEAR', :year) GROUP BY FUNCTION('YEAR', h.ngayTao)")
    BigDecimal doanhThuTheoNam(@Param("year") int year);
}

