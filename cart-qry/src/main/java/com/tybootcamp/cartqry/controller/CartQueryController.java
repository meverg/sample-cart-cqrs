package com.tybootcamp.cartqry.controller;

import com.tybootcamp.cartqry.entity.Cart;
import com.tybootcamp.cartqry.query.FindActiveCartOfCustomerQuery;
import java.util.concurrent.CompletableFuture;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meverg
 */
@RestController
@RequestMapping("cart")
public class CartQueryController {

  private final QueryGateway queryGateway;

  public CartQueryController(QueryGateway queryGateway) {
    this.queryGateway = queryGateway;
  }

  @GetMapping
  public CompletableFuture<Cart> getActiveCartOfCustomer(@RequestParam String customerId) {
    return queryGateway.query(new FindActiveCartOfCustomerQuery(customerId), ResponseTypes.instanceOf(Cart.class));
  }
}
