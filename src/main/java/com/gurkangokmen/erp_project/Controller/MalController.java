package com.gurkangokmen.erp_project.Controller;

import com.gurkangokmen.erp_project.Entity.Mal;
import com.gurkangokmen.erp_project.Service.MalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MalController {
    private MalService malService;

    @Autowired
    public MalController(MalService theMalService){
        malService = theMalService;
    }

    @GetMapping("/mal/{id}")
    public ResponseEntity<Mal> getMalById(@PathVariable Long id) {
        return new ResponseEntity<>(malService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/mal")
    public ResponseEntity<List<Mal>> getAllMal() {
        return new ResponseEntity<>(malService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/mal")
    public ResponseEntity<Mal> saveMal(@RequestBody Mal mal){
        malService.save(mal);
        return new ResponseEntity<>(mal, HttpStatus.CREATED);
    }

    @PutMapping("/mal")
    public ResponseEntity<Mal> updateMal(@RequestBody Mal mal){
        malService.update(mal);
        return new ResponseEntity<>(mal, HttpStatus.OK);
    }

    @DeleteMapping("/mal/{id}")
    public ResponseEntity<Void> deleteMal(@PathVariable Long id){
        malService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
