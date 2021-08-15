package com.trendyol.stockqry.handler;

import com.trendyol.stockqry.entity.Product;
import com.trendyol.stockqry.query.FindProductByIdQuery;
import com.trendyol.stockqry.repository.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
@ProcessingGroup("products")
public class ProductQueryHandler {

  private final ProductRepository repository;

  public ProductQueryHandler(ProductRepository repository) {
    this.repository = repository;
  }

  @QueryHandler
  public Product handle(FindProductByIdQuery query) {
    return repository.findById(query.getProductId()).orElseThrow(); // todo correct exception
  }
}
