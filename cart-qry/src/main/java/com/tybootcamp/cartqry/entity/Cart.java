package com.tybootcamp.cartqry.entity;

import java.util.HashMap;
import java.util.Map;
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
  private Map<String, Item> items;

  @Field
  private Boolean active;

  public Cart(String id, String customerId) {
    this.id = id;
    this.customerId = customerId;
    this.items = new HashMap<>();
    this.active = true;
  }

  public String getId() {
    return id;
  }

  public String getCustomerId() {
    return customerId;
  }

  public Map<String, Item> getItems() {
    return items;
  }

  public void setItems(Map<String, Item> items) {
    this.items = items;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}