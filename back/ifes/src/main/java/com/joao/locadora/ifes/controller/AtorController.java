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

import com.joao.locadora.ifes.dto.AtorDTO;
import com.joao.locadora.ifes.service.AtorService;

@RestController
@RequestMapping("/ator")
public class AtorController {
    @Autowired
    private AtorService atorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody AtorDTO atorDTO){
        try{
            String sucess = this.atorService.save(atorDTO);
            return new ResponseEntity<>(sucess,HttpStatus.OK); 
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{id}")
    public ResponseEntity<AtorDTO> findById(@PathVariable Long id){
        try{
            AtorDTO atorDTO = this.atorService.findById(id);
            return new ResponseEntity<>(atorDTO, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody AtorDTO atorDTO, @PathVariable Long id){
        try {
            String sucess = this.atorService.update(atorDTO, id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findAll")
    public ResponseEntity<List<AtorDTO>> findAll(){
        try {
            ResponseEntity<List<AtorDTO>> atorDTO = this.atorService.findAll();
            return atorDTO;
            //return new ResponseEntity<>(atorDTO,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            String sucess = this.atorService.deleteById(id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
