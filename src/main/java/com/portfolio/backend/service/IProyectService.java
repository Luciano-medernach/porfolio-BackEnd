package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.model.Proyect;

public interface IProyectService {
    public List<Proyect> getProyects();

    public void saveProyect(Proyect proyect);
    public void deleteProyect(Long id);
    public Proyect findProyect(Long id);
}
