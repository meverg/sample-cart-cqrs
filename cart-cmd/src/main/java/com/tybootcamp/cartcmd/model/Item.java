package com.tybootcamp.cartcmd.model;

import org.axonframework.modelling.command.EntityId;

/**
 * @author meverg
 */
public class Item {

  @EntityId
  private final String productId;

  private Integer quantity;

  private final Integer priceWhenAddedToCart; // for unit in cents

  public Item(String productId, Integer quantity, Integer priceWhenAddedToCart) {
    this.productId = productId;
    this.quantity = quantity;
    this.priceWhenAddedToCart = priceWhenAddedToCart;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getProductId() {
    return productId;
  }

  public Integer getPriceWhenAddedToCart() {
    return priceWhenAddedToCart;
  }
}
