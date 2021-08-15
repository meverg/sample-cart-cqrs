package com.tybootcamp.cartqry.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * @author meverg
 */
@Document
public class Cart {

  @Id
  private final String id;

  @Field
  private final String customerId;

  @Field
  private List<Item> items;

  @Field
  private Boolean active;

  public Cart(String id, String customerId) {
    this.id = id;
    this.customerId = customerId;
    this.items = new ArrayList<>();
    this.active = true;
  }

  public String getId() {
    return id;
  }

  public String getCustomerId() {
    return customerId;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}