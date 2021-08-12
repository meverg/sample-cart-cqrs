package com.tybootcamp.cartcmd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meverg
 */
@RestController
public class CartCommandController {

  @RequestMapping("/hello")
  public String hello() {
    System.out.println("hello");
    return "hello";
  }
}
