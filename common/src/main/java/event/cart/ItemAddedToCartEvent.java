package event.cart;

import java.util.Objects;
import model.Product;

/**
 * @author meverg
 */
public class ItemAddedToCartEvent {

  private final String cartId;

  private final Product product;

  private final Integer quantity;

  public ItemAddedToCartEvent(String cartId, Product product, Integer quantity) {
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
    ItemAddedToCartEvent that = (ItemAddedToCartEvent) o;
    return Objects.equals(cartId, that.cartId)
           && Objects.equals(product, that.product)
           && Objects.equals(quantity, that.quantity);
  }

  @Override public int hashCode() {
    return Objects.hash(cartId, product, quantity);
  }

  @Override public String toString() {
    return "ItemAddedToCartEvent{" +
           "cartId='" + cartId + '\'' +
           ", product=" + product +
           ", quantity=" + quantity +
           '}';
  }
}
