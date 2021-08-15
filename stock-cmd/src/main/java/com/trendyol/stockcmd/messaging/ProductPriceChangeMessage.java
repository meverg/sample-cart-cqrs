package com.trendyol.stockcmd.messaging;

import java.io.Serializable;
import java.util.Date;

/**
 * @author meverg
 */
public class ProductPriceChangeMessage implements Serializable {

  private String productId;

  private Integer updatedPrice;

  private Date updatedAt;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Integer getUpdatedPrice() {
    return updatedPrice;
  }

  public void setUpdatedPrice(Integer updatedPrice) {
    this.updatedPrice = updatedPrice;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override public String toString() {
    return "ProductPriceChangeMessage{" +
           "productId='" + productId + '\'' +
           ", updatedPrice=" + updatedPrice +
           ", updatedAt=" + updatedAt +
           '}';
  }
}
