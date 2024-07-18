package com.gurkangokmen.erp_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isim;
    private String detay;

    @OneToMany(mappedBy = "mal")
    @JsonIgnore
    private List<Siparis> siparis;

    public Mal(String isim, String detay) {
        this.isim = isim;
        this.detay = detay;
    }

    public void add(Siparis tempSiparis) {

        if (siparis == null) {
            siparis = new ArrayList<>();
        }

        siparis.add(tempSiparis);

        tempSiparis.setMal(this);
    }

    @Override
    public String toString() {
        return "Mal{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", detay='" + detay + '\'' +
                '}';
    }
}
