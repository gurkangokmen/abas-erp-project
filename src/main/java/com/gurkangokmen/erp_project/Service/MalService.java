package com.gurkangokmen.erp_project.Service;

import com.gurkangokmen.erp_project.Dao.MalRepository;
import com.gurkangokmen.erp_project.Entity.Mal;
import com.gurkangokmen.erp_project.exception.MalNotFoundException;
import com.gurkangokmen.erp_project.exception.MalPrimaryKeyCannotBeNegativeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MalService {
    private MalRepository malRepository;

    @Autowired
    public MalService(MalRepository theMalRepository){
        malRepository = theMalRepository;
    }

    public void save(Mal mal){
        malRepository.save(mal);
    }

    public void update(Mal mal){
        malRepository.save(mal);
    }

    public Mal findById(Long id){
        Optional<Mal> dbMal = malRepository.findById(id);

        Mal mal = null;

        if (dbMal.isPresent()){
            mal = dbMal.get();
        }

        else {
            throw  new MalNotFoundException("Mal is not found - "+id);
        }

        return mal;

    }

    public List<Mal> findAll(){
        return malRepository.findAll();
    }

    public void deleteById(Long id) {
        if (id<0){
            throw new MalPrimaryKeyCannotBeNegativeException("Mal primary key cannot be negative - "+id);
        }
        malRepository.deleteById(id);
    }
}
