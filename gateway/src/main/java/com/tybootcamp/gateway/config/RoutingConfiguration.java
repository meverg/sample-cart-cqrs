package com.tybootcamp.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @author meverg
 */
@Configuration
public class RoutingConfiguration {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
                  .route("cart command routing",
                         r -> r.path("/cart/**")
                               .and()
                               .method(HttpMethod.POST, HttpMethod.PUT)
                               .uri("lb://CART-CMD"))
                  .route("cart query routing",
                         r -> r.path("/cart/**")
                               .and()
                               .method(HttpMethod.GET)
                               .uri("lb://CART-QRY"))
                  .route("product command routing",
                         r -> r.path("/product/**")
                               .and()
                               .method(HttpMethod.POST, HttpMethod.PUT)
                               .uri("lb://STOCK-CMD"))
                  .route("product query routing",
                         r -> r.path("/product/**")
                               .and()
                               .method(HttpMethod.GET)
                               .uri("lb://STOCK-QRY"))
                  .build();
  }
}
