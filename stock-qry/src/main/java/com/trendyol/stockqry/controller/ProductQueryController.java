package com.trendyol.stockqry.controller;

import com.trendyol.stockqry.entity.Product;
import com.trendyol.stockqry.query.FindProductByIdQuery;
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
@RequestMapping("product")
public class ProductQueryController {

  private final QueryGateway queryGateway;

  public ProductQueryController(QueryGateway queryGateway) {
    this.queryGateway = queryGateway;
  }

  @GetMapping
  public CompletableFuture<Product> getProductById(@RequestParam String productId) {
    FindProductByIdQuery query = new FindProductByIdQuery(productId);
    return queryGateway.query(query, ResponseTypes.instanceOf(Product.class));
  }
}
