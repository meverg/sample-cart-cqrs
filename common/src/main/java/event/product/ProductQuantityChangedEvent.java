package event.product;

import java.util.Date;
import java.util.Objects;

/**
 * @author meverg
 */
public class ProductQuantityChangedEvent {

  private final String productId;

  private final Integer updatedQuantity;

  private final Date updatedAt;

  public ProductQuantityChangedEvent(String productId, Integer updatedQuantity, Date updatedAt) {
    this.productId = productId;
    this.updatedQuantity = updatedQuantity;
    this.updatedAt = updatedAt;
  }

  public String getProductId() {
    return productId;
  }

  public Integer getUpdatedQuantity() {
    return updatedQuantity;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductQuantityChangedEvent that = (ProductQuantityChangedEvent) o;
    return Objects.equals(productId, that.productId)
           && Objects.equals(updatedQuantity, that.updatedQuantity)
           && Objects.equals(updatedAt, that.updatedAt);
  }

  @Override public int hashCode() {
    return Objects.hash(productId, updatedQuantity, updatedAt);
  }

  @Override public String toString() {
    return "ProductQuantityChangedEvent{" +
           "productId='" + productId + '\'' +
           ", updatedQuantity=" + updatedQuantity +
           ", updatedAt=" + updatedAt +
           '}';
  }
}
