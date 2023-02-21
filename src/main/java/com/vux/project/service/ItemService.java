package com.vux.project.service;

import java.util.List;

import com.vux.project.entities.Item;

public interface ItemService {

	List<Item> findAll();
	Item findById(Integer id);
	Item save(Item item);
	void removeItem(Integer id);
}
