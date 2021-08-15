package com.tybootcamp.cartqry.model;

import java.util.Objects;

/**
 * @author meverg
 */
public class CartInfoDTO {

  private Double subTotal;

  private Double shipment;

  private Double total;

  /**
   *
   */
  public CartInfoDTO(Double subTotal, Double shipment, Double total) {
    this.subTotal = subTotal;
    this.shipment = shipment;
    this.total = total;
  }

  public Double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(Double subTotal) {
    this.subTotal = subTotal;
  }

  public Double getShipment() {
    return shipment;
  }

  public void setShipment(Double shipment) {
    this.shipment = shipment;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (CartInfoDTO) obj;
    return Objects.equals(this.subTotal, that.subTotal) &&
           Objects.equals(this.shipment, that.shipment) &&
           Objects.equals(this.total, that.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subTotal, shipment, total);
  }

  @Override
  public String toString() {
    return "CartInfoDTO[" +
           "subTotal=" + subTotal + ", " +
           "shipment=" + shipment + ", " +
           "total=" + total + ']';
  }
}
