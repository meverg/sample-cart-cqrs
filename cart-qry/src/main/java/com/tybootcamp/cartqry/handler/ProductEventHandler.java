package com.tybootcamp.cartqry.handler;

import com.tybootcamp.cartqry.entity.Cart;
import com.tybootcamp.cartqry.entity.Item;
import com.tybootcamp.cartqry.repository.CartRepository;
import event.product.ProductPriceChangedEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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
    String targetProductId = event.getProductId();
    List<Cart> carts = repository.findAllCartsContainingProduct(targetProductId);
    List<Cart> updatedCarts = carts.stream().map(c -> {
      List<Item> items = c.getItems();
      Map<String, Item> itemMap = items.stream().collect(Collectors.toMap(Item::getProductId, Function.identity()));
      Item item = itemMap.get(targetProductId);
      item.setPrice(event.getUpdatedPrice());
      itemMap.put(targetProductId, item);
      List<Item> updatedItems = new ArrayList<>(itemMap.values());
      c.setItems(updatedItems);
      return c;
    }).collect(Collectors.toList());
    repository.saveAll(updatedCarts);
  }
}
