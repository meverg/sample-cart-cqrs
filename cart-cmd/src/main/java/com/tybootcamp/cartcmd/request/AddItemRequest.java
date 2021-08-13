package com.tybootcamp.cartcmd.request;

/**
 * @author meverg
 */
public record AddItemRequest(String cartId,
                             String productId,
                             Integer quantity) {

}
