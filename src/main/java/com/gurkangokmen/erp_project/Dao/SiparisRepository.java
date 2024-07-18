package com.gurkangokmen.erp_project.Dao;

import com.gurkangokmen.erp_project.Entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiparisRepository extends JpaRepository<Siparis,Long> {
        List<Siparis> findBySiparisNo(Long siparis_numarasi);

        @Query("SELECT AVG(s.birim_fiyat) FROM Siparis s WHERE s.mal.id = :mal_id")
        double findAveragePriceByMalId(@Param("mal_id") Long mal_id);

        @Query("SELECT COUNT(s.siparisNo), s.siparisNo FROM Siparis s WHERE s.mal.id = :mal_id GROUP BY s.siparisNo")
        List<Object[]> findCountAndSiparisNumarasiByMalId(@Param("mal_id") Long mal_id);
 }
