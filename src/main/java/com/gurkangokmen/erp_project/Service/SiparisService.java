package com.gurkangokmen.erp_project.Service;

import com.gurkangokmen.erp_project.Dao.MalRepository;
import com.gurkangokmen.erp_project.Dao.SiparisRepository;
import com.gurkangokmen.erp_project.Entity.Mal;
import com.gurkangokmen.erp_project.Entity.Siparis;
import com.gurkangokmen.erp_project.exception.MalNotFoundException;
import com.gurkangokmen.erp_project.exception.MalPrimaryKeyCannotBeNegativeException;
import com.gurkangokmen.erp_project.exception.SiparisNotFoundException;
import com.gurkangokmen.erp_project.exception.SiparisPrimaryKeyCannotBeNegativeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiparisService {
    private SiparisRepository siparisRepository;
    private MalRepository malRepository;
    @Autowired
    public SiparisService(SiparisRepository theSiparisRepository, MalRepository theMalRepository){
        siparisRepository = theSiparisRepository;
        malRepository = theMalRepository;
    }

    public void save(Siparis siparis){
        siparisRepository.save(siparis);
    }

    public void addMalToSiparis(Siparis siparis, Long malId){

        Optional<Mal> dbMal = malRepository.findById(malId);

        Mal mal = null;

        if (dbMal.isPresent()){
            mal = dbMal.get();
        }

        else {
            throw  new MalNotFoundException("Mal is not found - "+malId);
        }

        mal.add(siparis);

        siparisRepository.save(siparis);
    }

    public void update(Siparis siparis){
        siparisRepository.save(siparis);
    }

    public Siparis findById(Long id){
        Optional<Siparis> dbSiparis = siparisRepository.findById(id);

        Siparis siparis = null;

        if (dbSiparis.isPresent()){
            siparis = dbSiparis.get();
        }

        else {
            throw  new SiparisNotFoundException("Siparis is not found - "+id);
        }

        return siparis;

    }

    public List<Siparis> findAll(){
        return siparisRepository.findAll();
    }

    public void deleteById(Long id) {
        if (id<0){
            throw new SiparisPrimaryKeyCannotBeNegativeException("Mal primary key cannot be negative - "+id);
        }
        siparisRepository.deleteById(id);
    }


}
