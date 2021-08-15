package com.trendyol.stockqry.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * @author meverg
 */
@Document
public class Product {

  @Id
  private final String id;

  @Field String title;

  @Field
  private Integer price;

  @Field
  private Date priceLastUpdatedAt;

  @Field
  private Integer quantity;

  @Field
  private Date quantityLastUpdatedAt;

  @Field
  private String imageUrl;

  @Field
  private Boolean active;

  public Product(String id, Integer price, Integer quantity, String title, String imageUrl) {
    this.id = id;
    this.price = price;
    this.quantity = quantity;
    this.title = title;
    this.imageUrl = imageUrl;
    this.active = true;
    Date now = new Date();
    this.priceLastUpdatedAt = now;
    this.quantityLastUpdatedAt = now;
  }

  public String getId() {
    return id;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getPriceLastUpdatedAt() {
    return priceLastUpdatedAt;
  }

  public void setPriceLastUpdatedAt(Date priceLastUpdatedAt) {
    this.priceLastUpdatedAt = priceLastUpdatedAt;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Date getQuantityLastUpdatedAt() {
    return quantityLastUpdatedAt;
  }

  public void setQuantityLastUpdatedAt(Date quantityLastUpdatedAt) {
    this.quantityLastUpdatedAt = quantityLastUpdatedAt;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
