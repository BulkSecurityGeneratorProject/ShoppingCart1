package com.jackson.shoppingcart.repository;

import com.jackson.shoppingcart.domain.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query( "select distinct c.cartItems " +
            "from Cart c " +
            "where c.customer = :customer ")
    List<CartItem> findAllWithEagerRelationships(@Param("customer") Customer customer);

    @Query( "select distinct c.cartItems " +
        "from Cart c " +
        "where c.customer = :customer ")
    Page<CartItem> findAllWithEagerRelationships(@Param("customer") Customer customer, Pageable pageable);

    @Query( "select distinct ci " +
        "from CartItem ci " +
        "where ci.cart = :cart and ci.product = :product")
    Optional<CartItem> findOneByCartAndProduct(@Param("cart") Cart cart, @Param("product") Product product);
}
