package com.joao.locadora.ifes.dto;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.entity.Diretor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiretorDTO {
    private Long id;
    private String nome;

    public DiretorDTO(Diretor diretor) {
        BeanUtils.copyProperties(diretor, this);
    }
}