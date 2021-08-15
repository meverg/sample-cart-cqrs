package com.tybootcamp.cartqry.model;

import java.util.List;
import java.util.Objects;

/**
 * @author meverg
 */
public class CartDTO {

  private List<CartItemDTO> items;

  private CartInfoDTO cartInfo;

  /**
   *
   */
  public CartDTO(List<CartItemDTO> items, CartInfoDTO cartInfo) {
    this.items = items;
    this.cartInfo = cartInfo;
  }

  public List<CartItemDTO> getItems() {
    return items;
  }

  public void setItems(List<CartItemDTO> items) {
    this.items = items;
  }

  public CartInfoDTO getCartInfo() {
    return cartInfo;
  }

  public void setCartInfo(CartInfoDTO cartInfo) {
    this.cartInfo = cartInfo;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (CartDTO) obj;
    return Objects.equals(this.items, that.items) &&
           Objects.equals(this.cartInfo, that.cartInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, cartInfo);
  }

  @Override
  public String toString() {
    return "CartDTO[" +
           "items=" + items + ", " +
           "cartInfo=" + cartInfo + ']';
  }
}
