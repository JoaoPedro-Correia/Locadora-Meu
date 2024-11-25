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

import com.joao.locadora.ifes.dto.ItemDTO;
import com.joao.locadora.ifes.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ItemDTO itemDTO){
        try{
            String sucess = this.itemService.save(itemDTO);
            return new ResponseEntity<>(sucess,HttpStatus.OK); 
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{id}")
    public ResponseEntity<ItemDTO> findById(@PathVariable Long id){
        try{
            ItemDTO itemDTO = this.itemService.findById(id);
            return new ResponseEntity<>(itemDTO,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ItemDTO itemDTO, @PathVariable Long id){
        try {
            String sucess = this.itemService.update(itemDTO, id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findAll")
    public ResponseEntity<List<ItemDTO>> findAll(){
        try {
            List<ItemDTO> itemDTO = this.itemService.findAll();
            return new ResponseEntity<>(itemDTO,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            String sucess = this.itemService.deleteById(id);
            return new ResponseEntity<>(sucess,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
