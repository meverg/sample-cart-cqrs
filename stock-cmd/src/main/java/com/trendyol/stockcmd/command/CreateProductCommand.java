package com.trendyol.stockcmd.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author meverg
 */
public class CreateProductCommand {

  @TargetAggregateIdentifier
  private final String productId;

  private final String title;

  private final Integer initialPrice;

  private final Integer initialQuantity;

  private final String imageUrl;

  public CreateProductCommand(String productId, String title, Integer initialPrice, Integer initialQuantity,
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
}
