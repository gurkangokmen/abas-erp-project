package com.gurkangokmen.erp_project.Service;

import com.gurkangokmen.erp_project.Dao.MalRepository;
import com.gurkangokmen.erp_project.Dao.SiparisRepository;
import com.gurkangokmen.erp_project.Entity.Siparis;
import com.gurkangokmen.erp_project.exception.SiparisNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private MalRepository malRepository;
    private SiparisRepository siparisRepository;


    @Autowired
    public TaskService(MalRepository malRepository, SiparisRepository siparisRepository) {
        this.malRepository = malRepository;
        this.siparisRepository = siparisRepository;
    }

    public double toplamFiyat(int ... siparisler) {
        double toplam = 0;

        for (int i = 0; i < siparisler.length; i++) {
            List<Siparis> dbSiparisList = siparisRepository.findBySiparisNo((long) siparisler[i]);

            if (dbSiparisList.size() == 0) {
                throw new SiparisNotFoundException("Siparis is not found - " + siparisler[i]);
            }

            for (int j = 0; j <dbSiparisList.size() ; j++) {
                toplam += dbSiparisList.get(j).getBirim_fiyat()*dbSiparisList.get(j).getMiktar();
            }


        }

        return toplam;
    }

    public double ortalamaFiyat(int ... siparisler) {
        int urunSayisi = 0;
        double toplam = 0;

        for (int i = 0; i < siparisler.length; i++) {
            List<Siparis> dbSiparisList = siparisRepository.findBySiparisNo((long) siparisler[i]);
            urunSayisi += dbSiparisList.size();
            if (dbSiparisList.size() == 0) {
                throw new SiparisNotFoundException("Siparis is not found - " + siparisler[i]);
            }

            for (int j = 0; j <dbSiparisList.size() ; j++) {
                toplam += dbSiparisList.get(j).getBirim_fiyat()*dbSiparisList.get(j).getMiktar();
            }


        }

        return toplam/urunSayisi;
    }

    public HashMap<Long,Double> findAveragePriceByMalId(int ... siparisler) {
        HashMap<Long, Double> result = new HashMap<>();

        for (int i = 0; i < siparisler.length; i++) {
            List<Siparis> dbSiparisList = siparisRepository.findBySiparisNo((long) siparisler[i]);

            if (dbSiparisList.size() == 0) {
                throw new SiparisNotFoundException("Siparis is not found - " + siparisler[i]);
            }

            for (int j = 0; j < dbSiparisList.size(); j++) {
                double avgPrice = siparisRepository.findAveragePriceByMalId(dbSiparisList.get(j).getMal().getId());
                result.put(dbSiparisList.get(j).getMal().getId(), avgPrice);
            }
        }
        return result;
    }

    public List<Object[]> getCountAndSiparisNumarasiByMalId(Long malId) {
        return siparisRepository.findCountAndSiparisNumarasiByMalId(malId);
    }

}
