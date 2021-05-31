package com.payment.sender.controller;

import com.payment.sender.config.SenderConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author songke
 * @version 1.0.0
 * @since 2021/05/19 15:16
 */
@RestController
@RequestMapping("/payment")
public class SenderController {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @PostMapping("/send/{msg}")
  public void send(@PathVariable("msg") String msg) {
    System.out.println("send [" + msg + "] success");
    rabbitTemplate.convertAndSend(SenderConfiguration.DELAY_EXCHANGE, SenderConfiguration.DELAY_QUEUE_1_ROUTE_KEY, msg);
  }
}
