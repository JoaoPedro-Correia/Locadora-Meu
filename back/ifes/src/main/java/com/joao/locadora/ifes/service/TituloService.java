package com.joao.locadora.ifes.service;

import com.joao.locadora.ifes.dto.TituloDTO;
import com.joao.locadora.ifes.entity.Titulo;
import com.joao.locadora.ifes.repository.TituloRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloService {
    @Autowired
    private TituloRepository tituloRepository;

    public String save(TituloDTO tituloDTO){
        Titulo titulo = new Titulo(tituloDTO);
        tituloRepository.save(titulo);
        return "Titulo salvo com sucesso!";
    }
    
    public String update(TituloDTO tituloDTO, Long id){
        tituloDTO.setId(id);
        this.tituloRepository.save(new Titulo(tituloDTO));
        return "Titulo atualizada com sucesso";
    }

    public TituloDTO findById(Long id){
        return new TituloDTO(this.tituloRepository.findById(id).get());
    }

    public List<TituloDTO> findAll(){
        List<TituloDTO> tituloDTOs = new ArrayList<>(500);
        this.tituloRepository.findAll().stream().filter((titulo) -> (tituloDTOs.add(new TituloDTO(titulo)))).toList();
        return tituloDTOs;
    }

    public String deleteById(Long id){
        this.tituloRepository.deleteById(id);
        return "Titulo removida com sucesso";
    }
}
