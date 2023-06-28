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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mausac")
public class MauSac implements Serializable {
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

    @OneToMany(mappedBy = "idMauSac", fetch = FetchType.LAZY)
    private List<ChiTietSP> listChiTietSP;
}
