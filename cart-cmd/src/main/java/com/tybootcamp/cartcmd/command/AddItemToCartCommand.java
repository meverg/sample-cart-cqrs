package com.tybootcamp.cartcmd.command;

import java.util.Objects;
import model.Product;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author meverg
 */
public class AddItemToCartCommand {

  @TargetAggregateIdentifier
  private final String cartId;

  private final Product product;

  private final Integer quantity;

  public AddItemToCartCommand(String cartId, Product product, Integer quantity) {
    this.cartId = cartId;
    this.product = product;
    this.quantity = quantity;
  }

  public String getCartId() {
    return cartId;
  }

  public Product getProduct() {
    return product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddItemToCartCommand that = (AddItemToCartCommand) o;
    return Objects.equals(cartId, that.cartId)
           && Objects.equals(product, that.product)
           && Objects.equals(quantity, that.quantity);
  }

  @Override public int hashCode() {
    return Objects.hash(cartId, product, quantity);
  }

  @Override public String toString() {
    return "AddItemToCartCommand{" +
           "cartId='" + cartId + '\'' +
           ", product=" + product +
           ", quantity=" + quantity +
           '}';
  }
}
