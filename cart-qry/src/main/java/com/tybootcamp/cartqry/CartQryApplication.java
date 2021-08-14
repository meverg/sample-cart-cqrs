package com.tybootcamp.cartqry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CartQryApplication {

  public static void main(String[] args) {
    SpringApplication.run(CartQryApplication.class, args);
  }
}
