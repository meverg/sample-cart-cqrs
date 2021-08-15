package com.trendyol.stockcmd.model;

import com.trendyol.stockcmd.command.CreateProductCommand;
import com.trendyol.stockcmd.command.UpdateProductPriceCommand;
import com.trendyol.stockcmd.command.UpdateProductQuantityCommand;
import event.product.ProductCreatedEvent;
import event.product.ProductPriceChangedEvent;
import event.product.ProductQuantityChangedEvent;
import java.util.Date;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * @author meverg
 */
@Aggregate
public class ProductAggregate {

  @AggregateIdentifier
  private String productId;

  private Boolean active;

  private Integer quantity;

  private Integer price;

  private String imageUrl;

  private Date priceLastUpdatedAt;

  private Date quantityLastUpdatedAt;

  // for axon use
  protected ProductAggregate() {
  }

  @CommandHandler
  public ProductAggregate(CreateProductCommand command) {
    ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(command.getProductId(),
                                                                      command.getTitle(),
                                                                      command.getInitialPrice(),
                                                                      command.getInitialQuantity(),
                                                                      command.getImageUrl());
    apply(productCreatedEvent);
  }

  @CommandHandler
  public void handle(UpdateProductPriceCommand command) {
    ProductPriceChangedEvent event = new ProductPriceChangedEvent(command.getProductId(),
                                                                  command.getUpdatedPrice(),
                                                                  command.getUpdatedAt());
    apply(event);
  }

  @CommandHandler
  public void handle(UpdateProductQuantityCommand command) {
    ProductQuantityChangedEvent event = new ProductQuantityChangedEvent(command.getProductId(),
                                                                        command.getUpdatedQuantity(),
                                                                        command.getUpdatedAt());
    apply(event);
  }

  @EventSourcingHandler
  public void on(ProductCreatedEvent event) {
    this.productId = event.getProductId();
    this.quantity = event.getInitialQuantity();
    this.price = event.getInitialPrice();
    this.imageUrl = event.getImageUrl();
    this.active = true;
    Date now = new Date();
    this.priceLastUpdatedAt = now;
    this.quantityLastUpdatedAt = now;
  }

  @EventSourcingHandler
  public void on(ProductPriceChangedEvent event) throws Exception {
    if (this.priceLastUpdatedAt.after(event.getUpdatedAt())) {
      throw new Exception(); //correct exception
    }
    this.price = event.getUpdatedPrice();
    this.priceLastUpdatedAt = event.getUpdatedAt();
  }

  @EventSourcingHandler
  public void on(ProductQuantityChangedEvent event) throws Exception {
    if (this.quantityLastUpdatedAt.after(event.getUpdatedAt())) {
      throw new Exception(); //correct exception
    }
    this.quantity = event.getUpdatedQuantity();
    this.quantityLastUpdatedAt = event.getUpdatedAt();
  }
}
