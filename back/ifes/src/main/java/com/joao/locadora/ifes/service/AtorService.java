package com.joao.locadora.ifes.service;

import com.joao.locadora.ifes.dto.AtorDTO;
import com.joao.locadora.ifes.entity.Ator;
import com.joao.locadora.ifes.repository.AtorRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtorService {
    @Autowired
    private AtorRepository atorRepository; 
    
    public String save(AtorDTO atorDTO){
        Ator ator = new Ator(atorDTO);
        this.atorRepository.save(ator);
        return "Ator salvo com sucesso!";
    }

    public String update(AtorDTO atorDTO, Long id){
        atorDTO.setId(id);
        Ator ator = new Ator(atorDTO);
        this.atorRepository.save(ator);
        return "Ator atualizada com sucesso";
    }

    public AtorDTO findById(Long id){
        return new AtorDTO(this.atorRepository.findById(id).get());
    }

    public List<AtorDTO> findAll(){
        List<AtorDTO> atorDTOs = new ArrayList<>(500);
        this.atorRepository.findAll().stream().filter((ator) -> (atorDTOs.add(new AtorDTO(ator)))).toList();
        return atorDTOs;
    }

    public String deleteById(Long id){
        this.atorRepository.deleteById(id);
        return "Ator removida com sucesso";
    }
}
