package com.tybootcamp.cartqry.handler;

import com.tybootcamp.cartqry.entity.Cart;
import com.tybootcamp.cartqry.entity.Item;
import com.tybootcamp.cartqry.repository.CartRepository;
import event.cart.CartCreatedEvent;
import event.cart.ItemAddedToCartEvent;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.Product;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
@ProcessingGroup("carts")
public class CartEventHandler {

  private final CartRepository repository;

  public CartEventHandler(CartRepository repository) {
    this.repository = repository;
  }

  @EventSourcingHandler
  public void on(CartCreatedEvent event) {
    // todo check existing cart (overwrite or exception?)
    Cart cart = new Cart(event.getCartId(), event.getCustomerId());
    repository.save(cart);
  }

  @EventSourcingHandler
  public void on(ItemAddedToCartEvent event) throws Exception {
    Optional<Cart> optionalCart = repository.findById(event.getCartId());
    if (optionalCart.isPresent()) {
      Cart cart = optionalCart.get();
      List<Item> itemList = cart.getItems();
      Map<String, Item> items = itemList.stream().collect(Collectors.toMap(Item::getProductId, Function.identity()));
      Product product = event.getProduct();
      Item itemInCart = items.get(product.getId());
      //
      if (Objects.nonNull(itemInCart)) {
        itemInCart.setQuantity(itemInCart.getQuantity() + event.getQuantity());
        items.put(itemInCart.getProductId(), itemInCart); // todo is needed?
      } else {
        Item addingItem = new Item();
        addingItem.setProductId(product.getId());
        addingItem.setQuantity(event.getQuantity());
        addingItem.setPrice(product.getPrice());
        addingItem.setTitle(product.getTitle());
        addingItem.setImageUrl(product.getImageUrl());
        addingItem.setPriceWhenAddedToCart(product.getPrice());
        items.put(addingItem.getProductId(), addingItem);
      }
      List<Item> updatedItems = items.values().stream().toList();
      cart.setItems(updatedItems); // todo is needed?
      repository.save(cart);
    } else {
      throw new Exception(); // todo correct exception
    }
  }
}
