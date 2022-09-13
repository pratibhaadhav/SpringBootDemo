package com.lti.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product_details")
public class Product {

	@Id
	private int prodId;
	private String prodName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Order_like",joinColumns=@JoinColumn(name="prod_id"),inverseJoinColumns =@JoinColumn (name="order_Id"))
	private List<Order> order_list = new ArrayList<Order>();

	public List<Order> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(List<Order> order_list) {
		this.order_list = order_list;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + "]";
	}

}
