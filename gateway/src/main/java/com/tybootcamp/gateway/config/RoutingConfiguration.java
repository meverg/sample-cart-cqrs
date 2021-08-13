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
                  .build();
  }
}
