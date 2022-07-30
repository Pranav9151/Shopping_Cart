package com.cg.cartservice.cartcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cartservice.cartmodel.CartModel;
import com.cg.cartservice.cartrepository.CartRepository;
import com.cg.cartservice.cartservice.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	 private CartService service;

	    @Autowired
	    public void setService(CartService service) {
	        this.service = service;
	    }
	
	    @PostMapping("/create")
	    public ResponseEntity<CartModel> save(@RequestBody CartModel cart) {
	        return new ResponseEntity<>(service.save(cart), HttpStatus.OK);
	    }

	    @PostMapping("/update")
	    public CartModel update(@RequestBody CartModel cart) {
	        return service.save(cart);
	    }

	    @GetMapping("/getall")
	    public ResponseEntity<List<CartModel>> getAllCarts() {
	        return service.getAllCarts();
	    }

	    @PutMapping("/cart/deleteItem/{itemId}")
	    public CartModel deleteItemFromCart(@RequestBody CartModel cart, @PathVariable String itemId) {
	        return service.deleteItemFromCart(cart, itemId);
	    }

	    @PutMapping("/cart/updateItemQuantity/{itemId}/{newQuantity}")
	    public CartModel updateCartItem(@RequestBody CartModel cart, @PathVariable String itemId, @PathVariable Integer newQuantity) {
	        return service.updateItemQuantity(cart, itemId, newQuantity);
	    }

	    @PutMapping("/cart/insertItem/{productId}/{itemQuantity}")
	    public CartModel insertItemToCart(@RequestBody CartModel cart, @PathVariable String productId, @PathVariable Integer itemQuantity) {
	        return service.insertItemToCart(cart, productId, itemQuantity);
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	CartRepository repo;
//	
//	@PostMapping("/addcart")
//	public String addCart(@RequestBody CartModel cart) {
//	    repo.save(cart);
//	    return "Added Product With Id "+ cart.getId();
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public String deleteproduct(@PathVariable String id) {
//	    repo.deleteById(id);
//	    return "Item deleted with Id "+ id;
//	}
	
	
	
	
	
//	@Autowired
//	private CartRepository cartRepository;
//	
//	@PostMapping("/")
//	public String addtoCart(@RequestBody CartModel cartmodel)
//	{
//
//		cartRepository.save(cartmodel);
//		return "Added Successfully";
//	}
//	
//	@GetMapping("/")
//	public ResponseEntity<?> showCart()
//	{
//		
//		return ResponseEntity.ok(this.cartRepository.findAll());
//	}


























//@Slf4j
//@RestController
//@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST}, allowCredentials = "true", origins = "*", maxAge = 3600)
//@RequestMapping("/cart")           api/v1/
//public class CartController {
//
//    private CartService cartService;
//
//    @Autowired
//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }
//
//    @PostMapping(value = "/create")
//    private ResponseEntity<T> create(@RequestBody CartRequest cartRequest) {
//        try {
//            Cart cart = cartService.saveOrUpdate(cartRequest);
//            return new ResponseEntity<>(cart, HttpStatus.CREATED);
//        } catch (Exception e) {
//            log.error("Create Cart method error {}", e.getMessage(), e);
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping(value = "/cartbycustomerid")
//    private ResponseEntity getCartByCustomerId(@RequestBody CartRequest cartRequest) {
//        try {
//            Cart cart = cartService.findCartByCustomerId(cartRequest);
//            return new ResponseEntity<>(cart, HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Find Cart by Customer id method error {}", e.getMessage(), e);
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping(value = "/carts")
//    private ResponseEntity getCarts() {
//        try {
//            List<Cart> carts = cartService.findAllCarts();
//            return new ResponseEntity<>(carts, HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Find Cart by Customer id method error {}", e.getMessage(), e);
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
   