package com.tybootcamp.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author meverg
 */
@Configuration
public class RoutingConfiguration {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
                  .route("cart command routing",
                         r -> r.path("/hello")
                               .uri("lb://CART-CMD"))
                  .build();
  }
}
