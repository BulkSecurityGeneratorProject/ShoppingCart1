package com.jackson.shoppingcart.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jackson.shoppingcart.domain.Cart;

import com.jackson.shoppingcart.domain.CartItem;
import com.jackson.shoppingcart.domain.Customer;
import com.jackson.shoppingcart.domain.Product;
import com.jackson.shoppingcart.repository.CartItemRepository;
import com.jackson.shoppingcart.repository.CartRepository;
import com.jackson.shoppingcart.repository.CustomerRepository;
import com.jackson.shoppingcart.repository.ProductRepository;
import com.jackson.shoppingcart.service.CartItemService;
import com.jackson.shoppingcart.web.rest.errors.BadRequestAlertException;
import com.jackson.shoppingcart.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Cart.
 */
@RestController
@RequestMapping("/api")
public class CartResource {

    private final Logger log = LoggerFactory.getLogger(CartResource.class);

    private static final String ENTITY_NAME = "cart";

    private final CartRepository cartRepository;

    private final CustomerRepository customerRepository;

    private final CartItemRepository cartItemRepository;

    private final ProductRepository productRepository;

    private final CartItemService cartItemService;


    public CartResource(CartRepository cartRepository, CustomerRepository customerRepository, CartItemRepository cartItemRepository, ProductRepository productRepository, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.cartItemService = cartItemService;
    }

    /**
     * POST  /carts : Create a new cart.
     *
     * @param cart the cart to create
     * @return the ResponseEntity with status 201 (Created) and with body the new cart, or with status 400 (Bad Request) if the cart has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/carts")
    @Timed
    public ResponseEntity<Cart> createCart(@Valid @RequestBody Cart cart) throws URISyntaxException {
        log.debug("REST request to save Cart : {}", cart);
        if (cart.getId() != null) {
            throw new BadRequestAlertException("A new cart cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cart result = cartRepository.save(cart);
        return ResponseEntity.created(new URI("/api/carts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /carts : Updates an existing cart.
     *
     * @param cart the cart to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated cart,
     * or with status 400 (Bad Request) if the cart is not valid,
     * or with status 500 (Internal Server Error) if the cart couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/carts")
    @Timed
    public ResponseEntity<Cart> updateCart(@Valid @RequestBody Cart cart) throws URISyntaxException {
        log.debug("REST request to update Cart : {}", cart);
        if (cart.getId() == null) {
            return createCart(cart);
        }
        Cart result = cartRepository.save(cart);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, cart.getId().toString()))
            .body(result);
    }

    /**
     * GET  /carts : get all the carts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of carts in body
     */
    @GetMapping("/carts")
    @Timed
    public List<Cart> getAllCarts() {
        log.debug("REST request to get all Carts");
        return cartRepository.findAll();
        }

    /**
     * GET  /carts/:id : get the "id" cart.
     *
     * @param id the id of the customer of cart to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the cart, or with status 404 (Not Found)
     */
    @GetMapping("/carts/{id}")
    @Timed
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        log.debug("REST request to get Cart : {}", id);
        Cart cart = cartRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(cart));
    }

    /**
     * GET  /carts/:id : get the cart items from a customer.
     *
     * @param id the id of the customer of cart to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the cart, or with status 404 (Not Found)
     */
    @GetMapping("/carts/customer/{id}")
    @Timed
    public List<CartItem> getAllCartItemsByCustomer(@PathVariable Long id) {
        log.debug("REST request to get Cart from customer: {}", id);
        Customer customer = customerRepository.findOne(id);
        return cartItemRepository.findAllWithEagerRelationships(customer);
    }

    /**
     * DELETE  /carts/:id : delete the "id" cart.
     *
     * @param id the id of the cart to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/carts/{id}")
    @Timed
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        log.debug("REST request to delete Cart : {}", id);
        cartRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * POST  /carts : Add item into Cart.
     *
     * @param cartId the cart to add item
     * @return the ResponseEntity with status 201 (Created) and with body the new cart, or with status 400 (Bad Request) if the cart has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/carts/{cartId}/product/{productId}")
    @Timed
    public ResponseEntity<CartItem> addItemToCart(@PathVariable Long cartId, @PathVariable Long productId)
            throws URISyntaxException{
        log.debug("REST request to add product into Cart : {}", cartId, productId);
        if (cartId == null || productId == null) {
            throw new BadRequestAlertException("Cart or Product does not exist", ENTITY_NAME, "idnotexists");
        }

        Cart cart = cartRepository.findOne(cartId);
        Product product = productRepository.findOne(productId);
        CartItem cartItem = cartItemService.addCartItemToCart(cart,product).get();
        return ResponseEntity.created(new URI("/api/carts/customer/" + cart.getCustomer().getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, cartItem.getId().toString()))
            .body(cartItem);
    }

    /**
     * DELETE  /carts/cartitem/:id : delete the "id" cart.
     *
     * @param id the id of the cartitem to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/carts/cartitem/{id}")
    @Timed
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        log.debug("REST request to delete CartItem : {}", id);
        cartItemRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
