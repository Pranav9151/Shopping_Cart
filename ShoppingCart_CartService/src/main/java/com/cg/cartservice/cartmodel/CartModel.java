package com.cg.cartservice.cartmodel;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "carts")
public class CartModel {

	
    @Id
    private String cartId;
    private Integer userId;
    private List<Item> item;
	public CartModel() {
		
	}
	public CartModel(String cartId, Integer userId, List<Item> item) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.item = item;
	}
	
	@Override
	public String toString() {
		return "CartModel{" + "cartId='" + cartId + '\'' +", userId=" + userId + ", item=" + item + '}';
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}

   
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    @Id
//    private String id;
//    private  String customerId;
//    private  String items;        
//    //List<Item>
//    
//	public String getId() {
//		return id;
//	}
//	public CartModel(String id, String customerId, String items) {
//		super();
//		this.id = id;
//		this.customerId = customerId;
//		this.items = items;
//	}
//	public CartModel() {
//		super();
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(String customerId) {
//		this.customerId = customerId;
//	}
//	public String getItems() {
//		return items;
//	}
//	public void setItems(String items) {
//		this.items = items;
//	}

    
