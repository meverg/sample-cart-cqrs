package event.product;

import java.util.Date;
import java.util.Objects;

/**
 * @author meverg
 */
public class ProductPriceChangedEvent {

  private final String productId;

  private final Integer updatedPrice;

  private final Date updatedAt;

  public ProductPriceChangedEvent(String productId, Integer updatedPrice, Date updatedAt) {
    this.productId = productId;
    this.updatedPrice = updatedPrice;
    this.updatedAt = updatedAt;
  }

  public String getProductId() {
    return productId;
  }

  public Integer getUpdatedPrice() {
    return updatedPrice;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductPriceChangedEvent that = (ProductPriceChangedEvent) o;
    return Objects.equals(productId, that.productId)
           && Objects.equals(updatedPrice, that.updatedPrice)
           && Objects.equals(updatedAt, that.updatedAt);
  }

  @Override public int hashCode() {
    return Objects.hash(productId, updatedPrice, updatedAt);
  }

  @Override public String toString() {
    return "ProductPriceChangedEvent{" +
           "productId='" + productId + '\'' +
           ", updatedPrice=" + updatedPrice +
           ", updatedAt=" + updatedAt +
           '}';
  }
}
