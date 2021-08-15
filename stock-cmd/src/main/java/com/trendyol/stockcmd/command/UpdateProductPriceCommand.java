package com.trendyol.stockcmd.command;

import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author meverg
 */
public class UpdateProductPriceCommand {

  @TargetAggregateIdentifier
  private final String productId;

  private final Integer updatedPrice;

  private final Date updatedAt;

  public UpdateProductPriceCommand(String productId, Integer updatedPrice, Date updatedAt) {
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
}
