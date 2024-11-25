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

import com.joao.locadora.ifes.dto.DiretorDTO;
import com.joao.locadora.ifes.service.DiretorService;

@RestController
@RequestMapping("/diretor")
public class DiretorController {
    @Autowired
    private DiretorService diretorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody DiretorDTO diretorDTO){
        try{
            String sucess = this.diretorService.save(diretorDTO);
            return new ResponseEntity<>(sucess,HttpStatus.OK); 
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{id}")
    public ResponseEntity<DiretorDTO> findById(@PathVariable Long id){
        try{
            DiretorDTO diretor = this.diretorService.findById(id);
            return new ResponseEntity<>(diretor,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody DiretorDTO diretorDTO, @PathVariable Long id){
        try {
            String sucess = this.diretorService.update(diretorDTO, id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findAll")
    public ResponseEntity<List<DiretorDTO>> findAll(){
        try {
            List<DiretorDTO> diretor = this.diretorService.findAll();
            return new ResponseEntity<>(diretor,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            String sucess = this.diretorService.deleteById(id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
