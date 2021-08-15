package com.tybootcamp.cartqry.entity;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * @author meverg
 */
@Document
public class Item {

  @Field
  private String productId;

  @Field
  private String title;

  @Field
  private String imageUrl;

  @Field
  private Integer quantity;

  @Field
  private Integer price; // for unit in cents

  @Field
  private Integer priceWhenAddedToCart; // for unit in cents

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Integer getPriceWhenAddedToCart() {
    return priceWhenAddedToCart;
  }

  public void setPriceWhenAddedToCart(Integer priceWhenAddedToCart) {
    this.priceWhenAddedToCart = priceWhenAddedToCart;
  }
}
