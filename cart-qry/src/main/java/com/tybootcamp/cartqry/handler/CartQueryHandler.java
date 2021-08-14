package com.tybootcamp.cartqry.handler;

import com.tybootcamp.cartqry.entity.Cart;
import com.tybootcamp.cartqry.query.FindActiveCartOfCustomerQuery;
import com.tybootcamp.cartqry.repository.CartRepository;
import java.util.Optional;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
@ProcessingGroup("carts")
public class CartQueryHandler {

  private final CartRepository repository;

  public CartQueryHandler(CartRepository repository) {
    this.repository = repository;
  }

  @QueryHandler
  public Cart handle(FindActiveCartOfCustomerQuery query) throws Exception {
    Optional<Cart> optionalCart = this.repository.findByCustomerIdAndActive(query.getCustomerId(), true);
    if (optionalCart.isEmpty()) {
      throw new Exception(); // todo correct exception
    }
    return optionalCart.get();
  }
}
