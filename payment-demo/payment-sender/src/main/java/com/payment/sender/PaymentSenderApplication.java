package com.payment.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO
 *
 * @author songke
 * @version 1.0.0
 * @since 2021/05/18 16:41
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.payment.sender.*"})
public class PaymentSenderApplication {
  public static void main(String[] args) {
    SpringApplication.run(PaymentSenderApplication.class, args);
  }
}
