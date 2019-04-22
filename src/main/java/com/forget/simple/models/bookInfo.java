package com.forget.simple.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class bookInfo {
	
	@Id
	public ObjectId _id;
	
	public String name;
	public int price;
	public String publication;
	
	public bookInfo() {}
	
	public bookInfo(String name, int price, String publication) {
		this.name = name;
		this.price = price;
		this.publication = publication;
	}
	
	public String get_id() { return _id.toHexString(); }
	public void set_id(ObjectId _id) { this._id = _id; }
	
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
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}

}
