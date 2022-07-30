package com.cg.cartservice.cartrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.cartservice.cartmodel.CartModel;

@Repository
public interface CartRepository extends MongoRepository<CartModel, String>{

	
    //insert a new cart or update if id already exist
    <S extends CartModel> S save (S cart);

    //find by cart id
    Optional findById(String id);

    //retrieve by user id
    CartModel findCartByUserId(Integer userId);

    @Override
    List<CartModel> findAll();
}
