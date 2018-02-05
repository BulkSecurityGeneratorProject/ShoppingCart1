package com.jackson.shoppingcart.repository;

import com.jackson.shoppingcart.domain.Cart;
import com.jackson.shoppingcart.domain.Customer;
import com.jackson.shoppingcart.domain.User;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.Optional;


/**
 * Spring Data JPA repository for the Cart entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findOneByCustomer(Customer customer);
}
