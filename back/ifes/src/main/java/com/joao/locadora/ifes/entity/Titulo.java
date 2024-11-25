package com.joao.locadora.ifes.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joao.locadora.ifes.dto.TituloDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private String sinopse;
    private String categoria;
    
    @ManyToOne
    @JsonIgnoreProperties("titulos")
    private Diretor diretor;

    @ManyToOne
    @JsonIgnoreProperties("titulos")
    private Classe classe;

    @ManyToMany
    @JoinTable(name = "titulo_ator")
    private List<Ator> atores;

    public Titulo(TituloDTO tituloDTO){
        BeanUtils.copyProperties(tituloDTO, this);
    }
}
