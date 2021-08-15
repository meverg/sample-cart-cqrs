package com.tybootcamp.cartcmd.controller;

import com.tybootcamp.cartcmd.command.AddItemToCartCommand;
import com.tybootcamp.cartcmd.command.CreateCartCommand;
import com.tybootcamp.cartcmd.request.AddItemRequest;
import com.tybootcamp.cartcmd.request.CreateCartRequest;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
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

  public CartCommandController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping()
  public CompletableFuture<Object> createCart(@RequestBody CreateCartRequest request) {
    String generatedCartId = UUID.randomUUID().toString();
    String customerId = request.customerId();
    CreateCartCommand createCartCommand = new CreateCartCommand(generatedCartId, customerId);
    return commandGateway.send(createCartCommand);
  }

  @PostMapping("item")
  public CompletableFuture<Object> addItemToCart(@RequestBody AddItemRequest request) {
    AddItemToCartCommand addItemToCartCommand = new AddItemToCartCommand(request.cartId(),
                                                                         request.productId(),
                                                                         request.quantity());
    return commandGateway.send(addItemToCartCommand);
  }
}
