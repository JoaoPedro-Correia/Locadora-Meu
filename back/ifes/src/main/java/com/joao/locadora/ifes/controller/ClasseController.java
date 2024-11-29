package com.joao.locadora.ifes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.locadora.ifes.dto.ClasseDTO;
import com.joao.locadora.ifes.service.ClasseService;

@RestController
@RequestMapping("/classe")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ClasseDTO classeDTO){
        try{
            String sucess = this.classeService.save(classeDTO);
            return new ResponseEntity<>(sucess,HttpStatus.OK); 
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ClasseDTO> findById(@PathVariable Long id){
        try{
            ClasseDTO classeDTO = this.classeService.findById(id);
            return new ResponseEntity<>(classeDTO,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
 
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ClasseDTO classeDTO, @PathVariable Long id){
        try {
            String sucess = this.classeService.update(classeDTO, id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ClasseDTO>> findAll(){
        try {
            List<ClasseDTO> classe = this.classeService.findAll();
            return new ResponseEntity<>(classe,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            String sucess = this.classeService.deleteById(id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
