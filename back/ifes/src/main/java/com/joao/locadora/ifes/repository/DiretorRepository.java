package com.joao.locadora.ifes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.locadora.ifes.entity.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
    
}