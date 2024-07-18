package com.gurkangokmen.erp_project.Controller;

import com.gurkangokmen.erp_project.Entity.Siparis;
import com.gurkangokmen.erp_project.Service.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiparisController {
    private SiparisService siparisService;

    @Autowired
    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }

    @GetMapping("/siparis/{id}")
    public ResponseEntity<Siparis> getSiparisById(@PathVariable Long id) {
        return new ResponseEntity<>(siparisService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/siparis")
    public ResponseEntity<List<Siparis>> getAllSiparis() {
        return new ResponseEntity<>(siparisService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/siparis/addMal/{siparisId}/{malId}")
    public ResponseEntity<Siparis> addMalToSiparis(@RequestBody Siparis siparis, @PathVariable Long malId){
        siparisService.addMalToSiparis(siparis, malId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/siparis")
    public ResponseEntity<Siparis> saveSiparis(@RequestBody Siparis siparis){
        siparisService.save(siparis);
        return new ResponseEntity<>(siparis, HttpStatus.CREATED);
    }

    @PutMapping("/siparis")
    public ResponseEntity<Siparis> updateSiparis(@RequestBody Siparis siparis){
        siparisService.update(siparis);
        return new ResponseEntity<>(siparis, HttpStatus.OK);
    }

    @DeleteMapping("/siparis/{id}")
    public ResponseEntity<Void> deleteSiparis(@PathVariable Long id){
        siparisService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
