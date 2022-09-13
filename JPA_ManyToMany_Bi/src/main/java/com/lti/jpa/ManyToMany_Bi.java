package com.lti.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToMany_Bi {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		Product p1 = new Product();
		p1.setProdId(11);
		p1.setProdName("Pen");

		Product p2 = new Product();
		p2.setProdId(12);
		p2.setProdName("Pencil");

		Order o1 = new Order();
		o1.setOrdId(1000);
		o1.setOrdName("ord-1");

		Order o2 = new Order();
		o2.setOrdId(2000);
		o2.setOrdName("ord-2");

		// p1 product belongs to 2 orders i,e order 1 and order2
		List<Order> olist1 = new ArrayList<Order>();
		olist1.add(o1);
		olist1.add(o2);

		p1.setOrder_list(olist1);

		// product-2 belongs to only one order i.e order2
		List<Order> olist2 = new ArrayList<Order>();
		olist2.add(o2);

		p2.setOrder_list(olist2);

		// product list setting to order-1
		List<Product> plist1 = new ArrayList<Product>();
        plist1.add(p1);
		o1.setPlist(plist1);
		
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();

		//Order can Access the product details.
		System.out.println("Order can Access the product details.");
		Order order = em.find(Order.class,1000);
		List<Product> products = order.getPlist();
		
		for(Product p:products)
		{
			System.out.println("ProductName: "+p.getProdName());
		}
		
		System.out.println("Product can Access the Order details.");
		//Order order1 = em.find(Order.class,1000);
		Product prod = em.find(Product.class,12);
		List<Order> orders = prod.getOrder_list();
		
		for(Order o:orders)
		{
			System.out.println("OrdertName: "+o.getOrdName());
		}
		
		
	}

}
