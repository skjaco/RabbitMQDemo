package com.payment.sender.config.controller;

import com.payment.sender.config.SenderConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author songke
 * @version 1.0.0
 * @since 2021/05/19 15:16
 */
@RestController("/payment")
public class SenderController {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @GetMapping("/{msg}")
  public void send(@PathVariable("msg")String msg){
    rabbitTemplate.convertAndSend(SenderConfiguration.DELAY_EXCHANGE, SenderConfiguration.DELAY_QUEUE_1_ROUTE_KEY, msg);
  }
}
