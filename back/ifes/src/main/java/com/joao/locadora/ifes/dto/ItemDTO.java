package com.joao.locadora.ifes.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.entity.Item;
import com.joao.locadora.ifes.entity.Titulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String numSerie;
    private Date dtAquisicao;
    private String tipoItem;

    private Titulo titulo;

    public ItemDTO(Item item) {
        BeanUtils.copyProperties(item, this);
    }
}
