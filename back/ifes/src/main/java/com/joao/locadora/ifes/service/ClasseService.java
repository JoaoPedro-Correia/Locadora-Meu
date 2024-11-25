package com.joao.locadora.ifes.service;

import com.joao.locadora.ifes.dto.ClasseDTO;
import com.joao.locadora.ifes.entity.Classe;
import com.joao.locadora.ifes.repository.ClasseRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    public String save(ClasseDTO classeDTO){
        Classe classe = new Classe(classeDTO);
        this.classeRepository.save(classe);
        return "Salvo com sucesso!";
    }

    public String update(ClasseDTO classeDTO, Long id){
        Classe classe = new Classe(classeDTO);
        classe.setId(id);
        this.classeRepository.save(classe);
        return "Classe atualizada com sucesso";
    }

    public ClasseDTO findById(Long id){
        return new ClasseDTO(this.classeRepository.findById(id).get());
    }

    public List<ClasseDTO> findAll(){
        List<ClasseDTO> classeDTOs = new ArrayList<>(500);
        this.classeRepository.findAll().stream().filter((classe) -> (classeDTOs.add(new ClasseDTO(classe)))).toList();
        return classeDTOs;
    }

    public String deleteById(Long id){
        this.classeRepository.deleteById(id);
        return "Classe removida com sucesso";
    }
}
