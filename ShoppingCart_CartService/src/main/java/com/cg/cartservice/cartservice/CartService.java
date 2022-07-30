package com.cg.cartservice.cartservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.cartservice.cartmodel.CartModel;
import com.cg.cartservice.cartmodel.Item;
import com.cg.cartservice.cartrepository.CartRepository;
import com.cg.cartservice.exception.CartException;


@Service
public class CartService {
    private CartRepository repository;
    @Autowired
    public void setRepository(CartRepository repository) {
        this.repository = repository;
    }

    //insert a new cart
    public <S extends CartModel> S save (S cart){
        return this.repository.save(cart);
    }

    //find by cart id
    public CartModel findOne(String id){
        return (CartModel)this.repository.findById(id).get();
    }

    //retrieve cart by user id
    public CartModel findCartByUserId(Integer integer){
        return this.repository.findCartByUserId(integer);
    }

    //delete item from cart by item id
    public CartModel deleteItemFromCart(CartModel cart, String itemId) {
        cart.getItem().removeIf(item -> item.getItemId().equals(itemId));
        this.repository.save(cart);
        return (CartModel)this.repository.findById(cart.getCartId()).get();
    }

    //update item quantity by item id
    public CartModel updateItemQuantity(CartModel cart, String itemId, Integer newQuantity){
        for( Item item:  cart.getItem()){
            if(item.getItemId().equals(itemId)){
                item.setQuantity(newQuantity);
            }
        }
        this.repository.save(cart);
        return (CartModel)this.repository.findById(cart.getCartId()).get();
    }

    //insert a new item into cart
    public CartModel insertItemToCart(CartModel cart, String productId, Integer itemQuantity){
        String itemId = cart.getUserId() + productId;
        cart.getItem().add(new Item(itemId, productId, itemQuantity));
        this.repository.save(cart);
        return (CartModel)this.repository.findById(cart.getCartId()).get();
    }

    public ResponseEntity<List<CartModel>> getAllCarts() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}


























//public class CartServiceImpl implements CartService{
//	 @Autowired
//	    public void setRepository(CartRepository repository) {
//	        this.repository = repository;
//	    }
//
//	@Override
//	public CartModel getallcart(CartModel cart, Product item) { 
//		return CartRepository.getallcart(cart);
//	}
//
//	@Override
//	public CartModel getcartbyid(CartModel cart, Product item, int quantity) {
//		return CartRepository.findById(cartId).orElseThrow(() -> new CartException("Cart not found with id: "+cartId));
//	
//	}
//
//	@Override
//	public ResponseEntity<List<cart>> getallCarts {
//	     return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
//	    }
//	}
//
//	@Override
//	public CartModel addingcart(CartModel cart, Product item) {
//		  String itemId = cart.getUserId() + productId;
//	        cart.getItem().add(new Item(itemId, productId, itemQuantity));
//	        this.repository.save(cart);
//	        return (Cart)this.repository.findById(cart.getCartId()).get();
//	}
//
//	@Override
//	public CartModel updatingCart(CartModel cart, Product item, Integer quantity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//}
