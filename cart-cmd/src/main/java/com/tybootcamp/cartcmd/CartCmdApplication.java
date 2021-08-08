package com.tybootcamp.cartcmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CartCmdApplication {

  public static void main(String[] args) {
    SpringApplication.run(CartCmdApplication.class, args);
  }
}
