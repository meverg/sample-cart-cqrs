package com.trendyol.stockcmd.messaging;

import java.io.Serializable;
import java.util.Date;

/**
 * @author meverg
 */
public class ProductQuantityChangeMessage implements Serializable {

  private String productId;

  private Integer updatedQuantity;

  private Date updatedAt;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Integer getUpdatedQuantity() {
    return updatedQuantity;
  }

  public void setUpdatedQuantity(Integer updatedQuantity) {
    this.updatedQuantity = updatedQuantity;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override public String toString() {
    return "ProductQuantityChangeMessage{" +
           "productId='" + productId + '\'' +
           ", updatedQuantity=" + updatedQuantity +
           ", updatedAt=" + updatedAt +
           '}';
  }
}
