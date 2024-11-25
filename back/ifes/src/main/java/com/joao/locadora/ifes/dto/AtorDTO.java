package com.joao.locadora.ifes.dto;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.entity.Ator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtorDTO {
    private Long id;
    private String nome;

    public AtorDTO(Ator ator) { 
        BeanUtils.copyProperties(ator, this);
    }
}
