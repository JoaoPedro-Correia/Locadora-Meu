package com.joao.locadora.ifes.service;

import com.joao.locadora.ifes.dto.DiretorDTO;
import com.joao.locadora.ifes.entity.Diretor;
import com.joao.locadora.ifes.repository.DiretorRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;

    public String save(DiretorDTO diretorDTO){
        Diretor diretor = new Diretor(diretorDTO);
        diretorRepository.save(diretor);
        return "Salvo com sucesso!";
    }
    
    public String update(DiretorDTO diretorDTO, Long id){
        Diretor diretor = new Diretor(diretorDTO);
        diretor.setId(id);
        this.diretorRepository.save(diretor);
        return "Diretor atualizada com sucesso";
    }

    public DiretorDTO findById(Long id){
        return new DiretorDTO(this.diretorRepository.findById(id).get());
    }

    public List<DiretorDTO> findAll(){
        List<DiretorDTO> diretorDTOs = new ArrayList<>(500);
        this.diretorRepository.findAll().stream().filter((diretor) -> (diretorDTOs.add(new DiretorDTO(diretor)))).toList();
        return diretorDTOs;
    }

    public String deleteById(Long id){
        this.diretorRepository.deleteById(id);
        return "Diretor removida com sucesso";
    }
}
