package com.tybootcamp.cartcmd.model;

import org.axonframework.modelling.command.EntityId;

/**
 * @author meverg
 */
public class Item {

  @EntityId
  private final String productId;

  private Integer quantity;

  private Integer price; // in cents

  public Item(String productId) {
    this.productId = productId;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
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
}
