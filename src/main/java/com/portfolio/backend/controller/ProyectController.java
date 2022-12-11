package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.model.Proyect;
import com.portfolio.backend.service.ProyectService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProyectController {
    
    @Autowired
    private ProyectService proyectService;

    @GetMapping ("/proyects")
    public List<Proyect> getProyects(){
        return proyectService.getProyects();
    }

    @PostMapping("/proyects/save")
    public Proyect saveProyect(@RequestBody Proyect proyect){
        proyectService.saveProyect(proyect);
        return proyect;
    }

    @PutMapping("/proyects/edit/{id}")
    public Proyect editProyect(@PathVariable Long id,
    @RequestParam String title,
    @RequestParam String description,
    @RequestParam String date){
        Proyect proyect = proyectService.findProyect(id);

        proyect.setTitle(title);
        proyect.setDescription(description);
        proyect.setDate(date);

        proyectService.saveProyect(proyect);

        return proyect;
    }
}
