package com.foodee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_items")
public class FoodItems {
	@Id
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private int price;
	@Column(name="enabled")
	private boolean enabled=true;
	@Column(name="image")
	private String imagUrl;
	
	

	public String getImagUrl() {
		return imagUrl;
	}
	public void setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "FoodItems [id=" + id + ", name=" + name + ", price=" + price + ", enabled=" + enabled + ", imagUrl="
				+ imagUrl + "]";
	}
	
	

}
