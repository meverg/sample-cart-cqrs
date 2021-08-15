package com.tybootcamp.cartqry.handler;

import com.tybootcamp.cartqry.entity.Cart;
import com.tybootcamp.cartqry.entity.Item;
import com.tybootcamp.cartqry.repository.CartRepository;
import event.cart.CartCreatedEvent;
import event.cart.ItemAddedToCartEvent;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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
      Map<String, Item> items = cart.getItems();
      Item itemInCart = items.get(event.getProductId());
      //
      if (Objects.nonNull(itemInCart)) {
        itemInCart.setQuantity(itemInCart.getQuantity() + event.getQuantity());
        items.put(itemInCart.getProductId(), itemInCart); // todo is needed?
      } else {
        Item addingItem = new Item();
        addingItem.setProductId(event.getProductId());
        addingItem.setQuantity(event.getQuantity());
        // todo get and set product price
        items.put(addingItem.getProductId(), addingItem);
      }
      cart.setItems(items); // todo is needed?
      repository.save(cart);
    } else {
      throw new Exception(); // todo correct exception
    }
  }
}
