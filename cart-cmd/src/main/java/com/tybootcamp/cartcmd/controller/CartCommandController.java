package com.tybootcamp.cartcmd.controller;

import com.tybootcamp.cartcmd.client.StockQueryServiceClient;
import com.tybootcamp.cartcmd.command.AddItemToCartCommand;
import com.tybootcamp.cartcmd.command.CreateCartCommand;
import com.tybootcamp.cartcmd.request.AddItemRequest;
import com.tybootcamp.cartcmd.request.CreateCartRequest;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import model.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meverg
 */
@RestController
@RequestMapping("cart")
public class CartCommandController {

  private final CommandGateway commandGateway;

  private final StockQueryServiceClient stockClient;

  public CartCommandController(CommandGateway commandGateway,
                               StockQueryServiceClient stockClient) {
    this.commandGateway = commandGateway;
    this.stockClient = stockClient;
  }

  @PostMapping()
  public CompletableFuture<Object> createCart(@RequestBody CreateCartRequest request) {
    String generatedCartId = UUID.randomUUID().toString();
    String customerId = request.customerId();
    CreateCartCommand createCartCommand = new CreateCartCommand(generatedCartId, customerId);
    return commandGateway.send(createCartCommand);
  }

  @PostMapping("item")
  public CompletableFuture<Object> addItemToCart(@RequestBody AddItemRequest request)
      throws ExecutionException, InterruptedException, TimeoutException {
    // todo separate add item and increase item
    Product product = stockClient.getProductById(request.productId());
    AddItemToCartCommand addItemToCartCommand = new AddItemToCartCommand(request.cartId(),
                                                                         product,
                                                                         request.quantity());
    return commandGateway.send(addItemToCartCommand);
  }
}
