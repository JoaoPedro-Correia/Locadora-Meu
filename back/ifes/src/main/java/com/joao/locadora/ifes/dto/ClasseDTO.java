package com.joao.locadora.ifes.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.entity.Classe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {
    private Long id;
    private String nome;
    private Double valor;
    private Date prazoDevolucao;

    public ClasseDTO(Classe classe) { 
        BeanUtils.copyProperties(classe, this);
    }
}
