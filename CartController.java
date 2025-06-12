package com.musclemart.musclemart.controller;

import com.musclemart.musclemart.entity.CartItem;
import com.musclemart.musclemart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return service.addToCart(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return service.getCartByUser(userId);
    }

    @PutMapping("/{id}")
    public CartItem updateCart(@PathVariable Long id, @RequestBody CartItem item) {
        return service.updateCartItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void removeCartItem(@PathVariable Long id) {
        service.removeCartItem(id);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        service.clearCart(userId);
    }
}
