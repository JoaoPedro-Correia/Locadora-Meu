package com.joao.locadora.ifes.service;

import com.joao.locadora.ifes.dto.ItemDTO;
import com.joao.locadora.ifes.entity.Item;
import com.joao.locadora.ifes.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public String save(ItemDTO itemDTO){
        Item item = new Item(itemDTO);
        itemRepository.save(item);
        return "Item salvo com sucesso!";
    }
    
    public String update(ItemDTO itemDTO, Long id){
        itemDTO.setId(id);
        this.itemRepository.save(new Item(itemDTO));
        return "Item atualizada com sucesso";
    }

    public ItemDTO findById(Long id){
        return new ItemDTO(this.itemRepository.findById(id).get());
    }

    public List<ItemDTO> findAll(){
        List<ItemDTO> itemDTOs = new ArrayList<>(500);
        this.itemRepository.findAll().stream().filter((item) -> itemDTOs.add(new ItemDTO(item))).toList();
        return itemDTOs;
    }

    public String deleteById(Long id){
        this.itemRepository.deleteById(id);
        return "Item removida com sucesso";
    }
}
