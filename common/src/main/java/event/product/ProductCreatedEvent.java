package event.product;

import java.util.Objects;

/**
 * @author meverg
 */
public class ProductCreatedEvent {

  private final String productId;

  private final String title;

  private final Integer initialPrice;

  private final Integer initialQuantity;

  private final String imageUrl;

  public ProductCreatedEvent(String productId, String title, Integer initialPrice, Integer initialQuantity,
                             String imageUrl) {
    this.productId = productId;
    this.title = title;
    this.initialPrice = initialPrice;
    this.initialQuantity = initialQuantity;
    this.imageUrl = imageUrl;
  }

  public String getProductId() {
    return productId;
  }

  public String getTitle() {
    return title;
  }

  public Integer getInitialPrice() {
    return initialPrice;
  }

  public Integer getInitialQuantity() {
    return initialQuantity;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductCreatedEvent that = (ProductCreatedEvent) o;
    return Objects.equals(productId, that.productId)
           && Objects.equals(title, that.title)
           && Objects.equals(initialPrice, that.initialPrice)
           && Objects.equals(initialQuantity, that.initialQuantity)
           && Objects.equals(imageUrl, that.imageUrl);
  }

  @Override public int hashCode() {
    return Objects.hash(productId, title, initialPrice, initialQuantity, imageUrl);
  }

  @Override public String toString() {
    return "ProductCreatedEvent{" +
           "productId='" + productId + '\'' +
           ", title='" + title + '\'' +
           ", initialPrice=" + initialPrice +
           ", initialQuantity=" + initialQuantity +
           ", imageUrl='" + imageUrl + '\'' +
           '}';
  }
}
