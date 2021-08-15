package com.tybootcamp.cartcmd.model;

import com.tybootcamp.cartcmd.command.AddItemToCartCommand;
import com.tybootcamp.cartcmd.command.CreateCartCommand;
import event.cart.CartCreatedEvent;
import event.cart.ItemAddedToCartEvent;
import java.util.HashMap;
import java.util.Map;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import static java.util.Objects.nonNull;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * @author meverg
 */
@Aggregate
public class CartAggregate {

  @AggregateIdentifier
  private String cartId;

  private Boolean active;

  @AggregateMember
  private Map<String, Item> items;

  private String customerId;

  // used by axon
  protected CartAggregate() {
  }

  @CommandHandler
  public CartAggregate(CreateCartCommand command) {
    // todo check if customer has active cart
    apply(new CartCreatedEvent(command.getCartId(), command.getCustomerId()));
  }

  @CommandHandler
  public void handle(AddItemToCartCommand command) throws Exception {
    if (!active) {
      throw new Exception();// todo correct exception
    }
    // todo check product available qty
    apply(new ItemAddedToCartEvent(command.getCartId(), command.getProductId(), command.getQuantity()));
  }

  @EventSourcingHandler
  public void on(CartCreatedEvent event) {
    this.cartId = event.getCartId();
    this.customerId = event.getCustomerId();
    this.active = true;
    this.items = new HashMap<>();
  }

  @EventSourcingHandler
  // todo refactor
  public void on(ItemAddedToCartEvent event) {
    String productId = event.getProductId();
    Item cartItem = items.get(productId);
    Integer addingQuantity = event.getQuantity();
    if (nonNull(cartItem)) {
      cartItem.setQuantity(cartItem.getQuantity() + addingQuantity);
      items.put(productId, cartItem);
    } else {
      Item addingItem = new Item(productId, 0); // todo correct price
      addingItem.setQuantity(addingQuantity);
      items.put(productId, addingItem);
    }
  }
}
