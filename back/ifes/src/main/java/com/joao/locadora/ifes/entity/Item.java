package com.joao.locadora.ifes.entity;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.joao.locadora.ifes.dto.ItemDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numSerie;
    private Date dtAquisicao;
    private String tipoItem;

    @ManyToOne
    private Titulo titulo;

    public Item(ItemDTO itemDTO) {
        BeanUtils.copyProperties(itemDTO, this);
    }
}
