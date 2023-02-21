package com.vux.project.dto;

import com.vux.project.entities.Item;

public class ItemDTO {

	private Integer id;
	private String text;
	private Boolean active;
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(Item item) {
		id = item.getId();
		text = item.getText();
		active = item.isActive();
	}
	
	public ItemDTO(Integer id, String text, Boolean active) {
		super();
		this.id = id;
		this.text = text;
		this.active = active;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	 
	 
	 
	 
}
