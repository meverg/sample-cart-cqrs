package event.cart;

import java.util.Objects;

/**
 * @author meverg
 */
public class ItemAddedToCartEvent {

  private final String cartId;

  private final String productId;

  private final Integer quantity;

  public ItemAddedToCartEvent(String cartId, String productId, Integer quantity) {
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
    ItemAddedToCartEvent that = (ItemAddedToCartEvent) o;
    return Objects.equals(cartId, that.cartId)
           && Objects.equals(productId, that.productId)
           && Objects.equals(quantity, that.quantity);
  }

  @Override public int hashCode() {
    return Objects.hash(cartId, productId, quantity);
  }

  @Override public String toString() {
    return "ItemAddedToCartEvent{" +
           "cartId='" + cartId + '\'' +
           ", productId='" + productId + '\'' +
           ", quantity=" + quantity +
           '}';
  }
}
