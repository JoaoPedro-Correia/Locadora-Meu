package com.joao.locadora.ifes.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.entity.Ator;
import com.joao.locadora.ifes.entity.Classe;
import com.joao.locadora.ifes.entity.Diretor;
import com.joao.locadora.ifes.entity.Titulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TituloDTO {
    private Long id;
    private String nome;
    private int ano;
    private String sinopse;
    private String categoria;

    private Diretor diretor;

    private Classe classe;

    private List<Ator> atores;

    public TituloDTO(Titulo titulo){
        BeanUtils.copyProperties(titulo, this);
    }
}
