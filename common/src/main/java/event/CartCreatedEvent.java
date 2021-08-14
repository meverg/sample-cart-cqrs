package event;

import java.util.Objects;

/**
 * @author meverg
 */
public class CartCreatedEvent {

  private final String cartId;

  private final String customerId;

  /**
   *
   */
  public CartCreatedEvent(String cartId, String customerId) {
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
    CartCreatedEvent that = (CartCreatedEvent) o;
    return Objects.equals(cartId, that.cartId) && Objects.equals(customerId, that.customerId);
  }

  @Override public int hashCode() {
    return Objects.hash(cartId, customerId);
  }

  @Override public String toString() {
    return "CartCreatedEvent{" +
           "cartId='" + cartId + '\'' +
           ", customerId='" + customerId + '\'' +
           '}';
  }
}
