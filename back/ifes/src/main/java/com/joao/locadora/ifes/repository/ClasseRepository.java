package com.joao.locadora.ifes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.locadora.ifes.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long>{
    
}
