package com.tybootcamp.cartqry.handler;

import com.tybootcamp.cartqry.entity.Cart;
import com.tybootcamp.cartqry.model.CartDTO;
import com.tybootcamp.cartqry.model.CartInfoDTO;
import com.tybootcamp.cartqry.model.CartItemDTO;
import com.tybootcamp.cartqry.query.FindActiveCartOfCustomerQuery;
import com.tybootcamp.cartqry.repository.CartRepository;
import java.util.List;
import java.util.stream.Collectors;
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
  public CartDTO handle(FindActiveCartOfCustomerQuery query) {
    Cart cart = this.repository.findByCustomerIdAndActive(query.getCustomerId(), true)
                               .orElseThrow();
    List<CartItemDTO> cartItemDTOS = cart.getItems()
                                         .stream()
                                         .map(item -> new CartItemDTO(item.getProductId(),
                                                                      item.getImageUrl(),
                                                                      item.getTitle(),
                                                                      item.getQuantity(),
                                                                      item.getPrice()))
                                         .collect(Collectors.toList());
    Integer subTotal = cartItemDTOS.stream().map(item -> item.getPrice() * item.getQuantity()).reduce(0, Integer::sum);
    CartInfoDTO cartInfoDTO = new CartInfoDTO(Double.valueOf(subTotal), 4.99, subTotal + 4.99);// todo shipment price
    return new CartDTO(cartItemDTOS, cartInfoDTO);
  }
}
