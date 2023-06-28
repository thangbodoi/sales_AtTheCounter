package com.example.demospring.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuahang")
public class CuaHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Column(name = "ma", length = 20)
    private String ma;

    @NotBlank
    @Column(name = "ten", length = 50)
    @NotBlank
    private String ten;

    @NotBlank
    @Column(name = "diachi", length = 100)
    private String diaChi;

    @NotBlank
    @Column(name = "thanhpho", length = 50)
    private String thanhPho;

    @NotBlank
    @Column(name = "quocgia", length = 50)
    private String quocGia;

    @OneToMany(mappedBy = "idCH", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;

}
