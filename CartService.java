package com.musclemart.musclemart.service;

import com.musclemart.musclemart.entity.CartItem;
import com.musclemart.musclemart.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository repository;

    public CartItem addToCart(CartItem item) {
        return repository.save(item);
    }

    public List<CartItem> getCartByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public CartItem updateCartItem(Long id, CartItem updatedItem) {
        CartItem item = repository.findById(id).orElse(null);
        if (item != null) {
            item.setQuantity(updatedItem.getQuantity());
            item.setPrice(updatedItem.getPrice());
            return repository.save(item);
        }
        return null;
    }

    public void removeCartItem(Long id) {
        repository.deleteById(id);
    }

    public void clearCart(Long userId) {
        List<CartItem> items = repository.findByUserId(userId);
        repository.deleteAll(items);
    }
}
