package com.gurkangokmen.erp_project.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "siparis_numarasi")
    private Long siparisNo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Mal mal;

    private int miktar;
    private double birim_fiyat;

    public Siparis(Long siparis_numarasi, int miktar, double birim_fiyat) {
        this.siparisNo = siparis_numarasi;
        this.miktar = miktar;
        this.birim_fiyat = birim_fiyat;
    }

    @Override
    public String toString() {
        return "Siparis{" +
                "id=" + id +
                ", siparis_numarasi=" + siparisNo +
                ", mal=" + mal +
                ", miktar=" + miktar +
                ", birim_fiyat=" + birim_fiyat +
                '}';
    }
}
