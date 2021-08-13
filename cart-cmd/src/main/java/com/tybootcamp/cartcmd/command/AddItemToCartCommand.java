package com.tybootcamp.cartcmd.command;

import java.util.Objects;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author meverg
 */
public class AddItemToCartCommand {

  @TargetAggregateIdentifier
  private final String cartId;

  private final String productId;

  private final Integer quantity;

  public AddItemToCartCommand(String cartId, String productId, Integer quantity) {
    this.cartId = cartId;
    this.productId = productId;
    this.quantity = quantity;
  }

  public String getCartId() {
    return cartId;
  }

  public String getProductId() {
    return productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddItemToCartCommand that = (AddItemToCartCommand) o;
    return Objects.equals(cartId, that.cartId)
           && Objects.equals(productId, that.productId)
           && Objects.equals(quantity, that.quantity);
  }

  @Override public int hashCode() {
    return Objects.hash(cartId, productId, quantity);
  }

  @Override public String toString() {
    return "AddItemToCartCommand{" +
           "cartId='" + cartId + '\'' +
           ", productId='" + productId + '\'' +
           ", quantity=" + quantity +
           '}';
  }
}
