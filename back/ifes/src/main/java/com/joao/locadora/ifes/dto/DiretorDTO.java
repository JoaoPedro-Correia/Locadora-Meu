package com.joao.locadora.ifes.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import com.joao.locadora.ifes.entity.Diretor;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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