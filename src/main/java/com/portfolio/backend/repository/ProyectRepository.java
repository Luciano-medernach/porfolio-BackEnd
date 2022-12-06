package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.portfolio.backend.model.Proyect;

@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Long> {
    
}
