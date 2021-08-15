package com.trendyol.stockcmd.controller;

import com.trendyol.stockcmd.command.CreateProductCommand;
import com.trendyol.stockcmd.request.CreateProductRequest;
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
@RequestMapping("product")
public class ProductCommandController {

  private final CommandGateway commandGateway;

  public ProductCommandController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping()
  public CompletableFuture<Object> createProduct(@RequestBody CreateProductRequest request) {
    String generatedProductId = UUID.randomUUID().toString();
    CreateProductCommand createProductCommand = new CreateProductCommand(generatedProductId,
                                                                         request.title(),
                                                                         request.initialPrice(),
                                                                         request.initialQuantity(),
                                                                         request.imageUrl());
    return commandGateway.send(createProductCommand);
  }
}
