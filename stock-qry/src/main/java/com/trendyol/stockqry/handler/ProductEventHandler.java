package com.trendyol.stockqry.handler;

import com.trendyol.stockqry.entity.Product;
import com.trendyol.stockqry.repository.ProductRepository;
import event.product.ProductCreatedEvent;
import event.product.ProductPriceChangedEvent;
import event.product.ProductQuantityChangedEvent;
import java.util.Optional;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
@ProcessingGroup("products")
public class ProductEventHandler {

  private final ProductRepository repository;

  public ProductEventHandler(ProductRepository repository) {
    this.repository = repository;
  }

  @EventSourcingHandler
  public void on(ProductCreatedEvent event) {
    Product product = new Product(event.getProductId(),
                                  event.getInitialPrice(),
                                  event.getInitialQuantity(),
                                  event.getTitle(),
                                  event.getImageUrl());
    repository.save(product);
  }

  @EventSourcingHandler
  public void on(ProductPriceChangedEvent event) throws Exception {
    Optional<Product> optionalProduct = repository.findById(event.getProductId());
    if (optionalProduct.isEmpty()) {
      throw new Exception(); // todo correct exception
    }
    Product product = optionalProduct.get();
    if (product.getPriceLastUpdatedAt().after(event.getUpdatedAt())) {
      throw new Exception(); // todo correct exception
    }
    product.setPrice(event.getUpdatedPrice());
    product.setPriceLastUpdatedAt(event.getUpdatedAt());
    repository.save(product);
  }

  @EventSourcingHandler
  public void on(ProductQuantityChangedEvent event) throws Exception {
    Optional<Product> optionalProduct = repository.findById(event.getProductId());
    if (optionalProduct.isEmpty()) {
      throw new Exception(); // todo correct exception
    }
    Product product = optionalProduct.get();
    if (product.getQuantityLastUpdatedAt().after(event.getUpdatedAt())) {
      throw new Exception(); // todo correct exception
    }
    product.setQuantity(event.getUpdatedQuantity());
    product.setQuantityLastUpdatedAt(event.getUpdatedAt());
    repository.save(product);
  }
}
