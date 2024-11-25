package com.joao.locadora.ifes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.locadora.ifes.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
