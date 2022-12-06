package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.backend.model.Proyect;
import com.portfolio.backend.repository.ProyectRepository;

public class ProyectService implements IProyectService {

    @Autowired
    private ProyectRepository proyectRepository;

    @Override
    public List<Proyect> getProyects() {
        List<Proyect> proyectList = proyectRepository.findAll();
        return proyectList;
    }

    @Override
    public void saveProyect(Proyect proyect) {
        proyectRepository.save(proyect);
        
    }

    @Override
    public void deleteProyect(Long id) {
        proyectRepository.deleteById(id);;
        
    }

    @Override
    public Proyect findProyect(Long id) {
        Proyect proyect = proyectRepository.findById(id).orElse(null);
        return proyect;
    }
    
    
}
