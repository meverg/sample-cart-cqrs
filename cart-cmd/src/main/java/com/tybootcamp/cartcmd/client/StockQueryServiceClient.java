package com.tybootcamp.cartcmd.client;

import model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author meverg
 */
@FeignClient("stock-qry")
public interface StockQueryServiceClient {

  @RequestMapping(value = "/product", method = GET)
  Product getProductById(@RequestParam String productId);
}
