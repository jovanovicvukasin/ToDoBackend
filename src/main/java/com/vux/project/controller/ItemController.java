package com.vux.project.controller;

import java.util.ArrayList;
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

import com.vux.project.dto.ItemDTO;
import com.vux.project.entities.Item;
import com.vux.project.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> getAllItems() {
		List<Item> items = itemService.findAll();
		//convert items to DTOs
		List<ItemDTO> itemsDTO = new ArrayList<>();
		for(Item i : items) {
			itemsDTO.add(new ItemDTO(i));
		}
		
		return new ResponseEntity<>(itemsDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ItemDTO> saveItem(@RequestBody ItemDTO itemDto) throws Exception {
		
		if(itemDto.getText() != null && itemDto.getText() != "") {
			Item newItem = new Item();
			newItem.setText(itemDto.getText());
			newItem.setActive(true);
			
			newItem = itemService.save(newItem);
			
			return new ResponseEntity<>(new ItemDTO(newItem), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemDTO> updateItem(@PathVariable Integer id) throws Exception {
		Item item = itemService.findById(id);
		if(item == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		item.setActive(false);
		
		item = itemService.save(item);
		
		return new ResponseEntity<>(new ItemDTO(item), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
		Item item = itemService.findById(id);
		if(item != null) {
			itemService.removeItem(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
