package com.jackson.shoppingcart.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Cart.
 */
@Entity
@Table(name = "cart")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "completed")
    private Boolean completed;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<CartItem> cartItems = new HashSet<>();

    @ManyToOne
    private Customer customer;

    // application-needle-entity-add-field - Application will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Cart title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public Cart completed(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public Cart cartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
        return this;
    }

    public Cart addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
        return this;
    }

    public Cart removeCartItem(CartItem cartItem) {
        this.cartItems.remove(cartItem);
        cartItem.setCart(null);
        return this;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // application-needle-entity-add-getters-setters - Application will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cart cart = (Cart) o;
        if (cart.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cart.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Cart{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", completed='" + isCompleted() + "'" +
            "}";
    }
}
