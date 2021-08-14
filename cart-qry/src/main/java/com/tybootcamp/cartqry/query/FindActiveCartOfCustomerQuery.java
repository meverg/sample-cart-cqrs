package com.tybootcamp.cartqry.query;

/**
 * @author meverg
 */
public class FindActiveCartOfCustomerQuery {

  private final String customerId;

  public FindActiveCartOfCustomerQuery(String customerId) {
    this.customerId = customerId;
  }

  public String getCustomerId() {
    return customerId;
  }
}
