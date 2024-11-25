package com.joao.locadora.ifes.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.dto.AtorDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "atores")
    private List<Titulo> titulos;

    public Ator(AtorDTO atorDTO) { 
        BeanUtils.copyProperties(atorDTO, this);
    }
}