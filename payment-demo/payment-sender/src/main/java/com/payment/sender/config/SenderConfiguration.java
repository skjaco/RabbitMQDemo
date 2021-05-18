package com.payment.sender.config;

import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author songke
 * @version 1.0.0
 * @since 2021/05/18 17:03
 */
@Configuration
public class SenderConfiguration {
  private static final String DELAY_QUEUE_1 = "delay.queue.1";
  private static final String DELAY_QUEUE_2 = "delay.queue.2";
  private static final String DELAY_QUEUE_3 = "delay.queue.3";

  private static final String DELAY_EXCHANGE = "delay.exchange";

  private static final String DELAY_QUEUE_1_ROUTE_KEY = "delay.queue.1.route.key";
  private static final String DELAY_QUEUE_2_ROUTE_KEY = "delay.queue.2.route.key";
  private static final String DELAY_QUEUE_3_ROUTE_KEY = "delay.queue.3.route.key";
}
