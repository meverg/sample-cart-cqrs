package com.trendyol.stockcmd.command;

import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author meverg
 */
public class UpdateProductQuantityCommand {

  @TargetAggregateIdentifier
  private final String productId;

  private final Integer updatedQuantity;

  private final Date updatedAt;

  public UpdateProductQuantityCommand(String productId, Integer updatedQuantity, Date updatedAt) {
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
}
