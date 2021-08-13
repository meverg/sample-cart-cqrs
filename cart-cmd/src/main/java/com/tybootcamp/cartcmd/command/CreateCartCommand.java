package com.tybootcamp.cartcmd.command;

import java.util.Objects;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author meverg
 */
public final class CreateCartCommand {

  @TargetAggregateIdentifier
  private final String cartId;

  private final String customerId;

  /**
   *
   */
  public CreateCartCommand(String cartId, String customerId) {
    this.cartId = cartId;
    this.customerId = customerId;
  }

  public String getCartId() {
    return cartId;
  }

  public String getCustomerId() {
    return customerId;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CreateCartCommand that = (CreateCartCommand) o;
    return Objects.equals(cartId, that.cartId) && Objects.equals(customerId, that.customerId);
  }

  @Override public int hashCode() {
    return Objects.hash(cartId, customerId);
  }

  @Override public String toString() {
    return "CreateCartCommand{" +
           "cartId='" + cartId + '\'' +
           ", customerId='" + customerId + '\'' +
           '}';
  }
}
