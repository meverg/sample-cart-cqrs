package com.trendyol.stockcmd.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author meverg
 */
public record CreateProductRequest(@NotEmpty String title,
                                   @Positive Integer initialPrice,
                                   @PositiveOrZero Integer initialQuantity,
                                   @NotEmpty String imageUrl) {

}
