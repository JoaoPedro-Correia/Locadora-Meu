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

import com.joao.locadora.ifes.dto.TituloDTO;
import com.joao.locadora.ifes.service.TituloService;

@RestController
@RequestMapping("/titulo")
public class TituloController {
    @Autowired
    private TituloService tituloService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody TituloDTO tituloDTO){
        try{
            String sucess = this.tituloService.save(tituloDTO);
            return new ResponseEntity<>(sucess,HttpStatus.OK); 
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<TituloDTO> findById(@PathVariable Long id){
        try{
            TituloDTO tituloDTO = this.tituloService.findById(id);
            return new ResponseEntity<>(tituloDTO,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody TituloDTO tituloDTO, @PathVariable Long id){
        try {
            String sucess = this.tituloService.update(tituloDTO, id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TituloDTO>> findAll(){
        try {
            List<TituloDTO> tituloDTO = this.tituloService.findAll();
            return new ResponseEntity<>(tituloDTO,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            String sucess = this.tituloService.deleteById(id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}