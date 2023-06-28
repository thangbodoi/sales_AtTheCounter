package com.example.demospring.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "chucvu")
public class ChucVu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Column(name = "ma", length = 20)
    private String ma;

    @NotBlank
    @Column(name = "ten", length = 50)
    private String ten;

    @OneToMany(mappedBy = "idCV", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;


}
