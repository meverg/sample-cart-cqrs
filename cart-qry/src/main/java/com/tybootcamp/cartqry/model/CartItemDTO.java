package com.tybootcamp.cartqry.model;

import java.util.Objects;

/**
 * @author meverg
 */
public class CartItemDTO {

  private String id;

  private String imageUrl;

  private String title;

  private Integer quantity;

  private Integer price;

  public CartItemDTO(String id,
                     String imageUrl,
                     String title,
                     Integer quantity,
                     Integer price) {
    this.id = id;
    this.imageUrl = imageUrl;
    this.title = title;
    this.quantity = quantity;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (CartItemDTO) obj;
    return Objects.equals(this.id, that.id) &&
           Objects.equals(this.imageUrl, that.imageUrl) &&
           Objects.equals(this.title, that.title) &&
           Objects.equals(this.quantity, that.quantity) &&
           Objects.equals(this.price, that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, imageUrl, title, quantity, price);
  }

  @Override
  public String toString() {
    return "CartItemDTO[" +
           "id=" + id + ", " +
           "imageUrl=" + imageUrl + ", " +
           "title=" + title + ", " +
           "quantity=" + quantity + ", " +
           "price=" + price + ']';
  }
}
