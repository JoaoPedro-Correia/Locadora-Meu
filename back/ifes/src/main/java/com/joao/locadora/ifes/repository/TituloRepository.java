package com.joao.locadora.ifes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.locadora.ifes.entity.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long>{
    
}
