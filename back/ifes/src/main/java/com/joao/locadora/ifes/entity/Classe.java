package com.joao.locadora.ifes.entity;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.dto.ClasseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    private Date prazoDevolucao;

    @OneToMany
    private List<Titulo> titulos;

    public Classe(ClasseDTO classeDto) {  
        BeanUtils.copyProperties(classeDto, this);
    }
}