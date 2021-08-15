package com.trendyol.stockcmd.messaging;

import com.trendyol.stockcmd.command.UpdateProductPriceCommand;
import com.trendyol.stockcmd.command.UpdateProductQuantityCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author meverg
 */
@Component
public class ExternalStockUpdateListener {

  private final CommandGateway commandGateway;

  public ExternalStockUpdateListener(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @RabbitListener(queues = "stock.product.quantity")
  public void productQuantityChangeListener(ProductQuantityChangeMessage message) {
    UpdateProductQuantityCommand command = new UpdateProductQuantityCommand(message.getProductId(),
                                                                            message.getUpdatedQuantity(),
                                                                            message.getUpdatedAt());
    commandGateway.send(command);
  }

  @RabbitListener(queues = "stock.product.price")
  public void productPriceChangeListener(ProductPriceChangeMessage message) {
    UpdateProductPriceCommand command = new UpdateProductPriceCommand(message.getProductId(),
                                                                      message.getUpdatedPrice(),
                                                                      message.getUpdatedAt());
    commandGateway.send(command);
  }
}
