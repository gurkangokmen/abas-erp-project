package com.gurkangokmen.erp_project.Controller;

import com.gurkangokmen.erp_project.Entity.Siparis;
import com.gurkangokmen.erp_project.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //http://localhost:8080/task?siparisler=1000&siparisler=1001&siparisler=1002
    @GetMapping("/task")
    public ResponseEntity<Double> toplamFiyat(@RequestParam  int ... siparisler) {
        return new ResponseEntity<>(taskService.toplamFiyat(siparisler), HttpStatus.OK);
    }

    //http://localhost:8080/task/ortalama?siparisler=1000&siparisler=1001&siparisler=1002
    @GetMapping("/task/ortalama")
    public double ortalamaFiyat(@RequestParam int ... siparisler) {
        return taskService.ortalamaFiyat(siparisler);
    }

    //http://localhost:8080/task/ortalamaFiyatMal?siparisler=1000&siparisler=1001&siparisler=1002
    @GetMapping("/task/ortalamaFiyatMal")
    public HashMap<Long,Double> ortalamaFiyatMal(@RequestParam int ... siparisler) {
        return taskService.findAveragePriceByMalId(siparisler);
    }

    //http://localhost:8080/task/countAndSiparisNumarasi?malId=2002
    @GetMapping("/task/countAndSiparisNumarasi")
    public List<Object[]> getCountAndSiparisNumarasiByMalId(@RequestParam Long malId) {
        return taskService.getCountAndSiparisNumarasiByMalId(malId);
    }
}
