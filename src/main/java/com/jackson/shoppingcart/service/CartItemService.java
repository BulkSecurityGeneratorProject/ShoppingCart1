package com.jackson.shoppingcart.service;

import com.jackson.shoppingcart.domain.Cart;
import com.jackson.shoppingcart.domain.CartItem;
import com.jackson.shoppingcart.domain.Customer;
import com.jackson.shoppingcart.domain.Product;
import com.jackson.shoppingcart.repository.CartItemRepository;
import com.jackson.shoppingcart.repository.CartRepository;
import com.jackson.shoppingcart.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Service Implementation for managing CartItem.
 */
@Service
@Transactional
public class CartItemService {

    private final Logger log = LoggerFactory.getLogger(CartItemService.class);

    private final CartItemRepository cartItemRepository;

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;


    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    /**
     * Get all the cart item by a customer.
     *
     * @param customer
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<CartItem> findAllCartItemByCustomer(Customer customer) {
        log.debug("Request to get all Cart Item By Customer");
        return cartItemRepository.findAllWithEagerRelationships(customer);
    }

    /**
     * Add an Cart Item into Cart
     *
     * @param cart
     * @param product
     * @return the list of entities
     */
    @Transactional(readOnly = false)
    public Optional<CartItem> addCartItemToCart(Cart cart, Product product) {
        log.debug("Add an Cart Item into Cart");
        CartItem cartItem;
        Optional<CartItem> c = cartItemRepository.findOneByCartAndProduct(cart, product);
        if (c.isPresent()) {
            c.get().setQuantity(c.get().getQuantity()+1);
            cartItem = c.get();
        } else {
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setPurchasedPrice(399.99);
        }
        cartItem = cartItemRepository.save(cartItem);
        Optional.of(cartItem);
        return Optional.of(cartItem);
    }

}
