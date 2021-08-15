package com.tybootcamp.cartqry.handler;

import com.tybootcamp.cartqry.repository.CartRepository;
import event.product.ProductPriceChangedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
@ProcessingGroup("carts")
public class ProductEventHandler {

  private final CartRepository repository;

  public ProductEventHandler(CartRepository repository) {
    this.repository = repository;
  }

  @EventSourcingHandler
  public void on(ProductPriceChangedEvent event) {
    //repository.
  }
}
