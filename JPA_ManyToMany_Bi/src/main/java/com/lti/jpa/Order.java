package com.lti.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Order_details")
public class Order {
	
	@Id
	private int ordId;
	private String ordName;
	
	@ManyToMany(mappedBy="order_list")//product is owner
	private List<Product>plist =  new ArrayList<Product>();
	
	
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", ordName=" + ordName + "]";
	}
	
	
	

}
