package com.payment.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author songke
 * @version 1.0.0
 * @since 2021/05/18 17:03
 */
@Configuration
public class SenderConfiguration {
  public static final String DELAY_QUEUE_1 = "delay.queue.1";
  private static final String DELAY_QUEUE_2 = "delay.queue.2";
  private static final String DELAY_QUEUE_3 = "delay.queue.3";
  private static final String DEAD_LETTER_QUEUE = "dead.letter.queue";


  public static final String DELAY_EXCHANGE = "delay.exchange";
  private static final String DEAD_EXCHANGE = "dead.exchange";

  public static final String DELAY_QUEUE_1_ROUTE_KEY = "delay.queue.1.route.key";
  private static final String DELAY_QUEUE_2_ROUTE_KEY = "delay.queue.2.route.key";
  private static final String DELAY_QUEUE_3_ROUTE_KEY = "delay.queue.3.route.key";
  private static final String DEAD_LETTER_QUEUE_ROUTE_KEY = "dead.letter.queue.route.key";

  @Bean
  public DirectExchange delayExchange() {
    return new DirectExchange(DELAY_EXCHANGE);
  }

  @Bean
  public DirectExchange deadExchange() {
    return new DirectExchange(DEAD_EXCHANGE);
  }

  @Bean
  public Queue delayQueue1() {
    Map<String, Object> args = new HashMap<>(4);
    // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
    args.put("x-dead-letter-exchange", DELAY_EXCHANGE);
    // x-dead-letter-routing-key  这里声明当前队列的死信路由key
    args.put("x-dead-letter-routing-key", DELAY_QUEUE_2_ROUTE_KEY);
    // x-message-ttl  声明队列的TTL
    args.put("x-message-ttl", 5000);
    return QueueBuilder.durable(DELAY_QUEUE_1).withArguments(args).build();
  }

  @Bean
  public Queue delayQueue2() {
    Map<String, Object> args = new HashMap<>(4);
    // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
    args.put("x-dead-letter-exchange", DELAY_EXCHANGE);
    // x-dead-letter-routing-key  这里声明当前队列的死信路由key
    args.put("x-dead-letter-routing-key", DELAY_QUEUE_3_ROUTE_KEY);
    // x-message-ttl  声明队列的TTL
    args.put("x-message-ttl", 10000);
    return QueueBuilder.durable(DELAY_QUEUE_2).withArguments(args).build();
  }

  @Bean
  public Queue delayQueue3() {
    Map<String, Object> args = new HashMap<>(4);
    // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
    args.put("x-dead-letter-exchange", DEAD_EXCHANGE);
    // x-dead-letter-routing-key  这里声明当前队列的死信路由key
    args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUE_ROUTE_KEY);
    // x-message-ttl  声明队列的TTL
    args.put("x-message-ttl", 120000);
    return QueueBuilder.durable(DELAY_QUEUE_3).withArguments(args).build();
  }

  @Bean
  public Queue deadLetterQueue() {
    return new Queue(DEAD_LETTER_QUEUE);
  }

  @Bean
  public Binding bindingDelay1() {
    return BindingBuilder.bind(delayQueue1()).to(delayExchange()).with(DELAY_QUEUE_1_ROUTE_KEY);
  }

  @Bean
  public Binding bindingDelay2() {
    return BindingBuilder.bind(delayQueue2()).to(delayExchange()).with(DELAY_QUEUE_2_ROUTE_KEY);
  }

  @Bean
  public Binding bindingDelay3() {
    return BindingBuilder.bind(delayQueue3()).to(delayExchange()).with(DELAY_QUEUE_3_ROUTE_KEY);
  }

  @Bean
  public Binding bindingDeadLetter() {
    return BindingBuilder.bind(deadLetterQueue()).to(deadExchange()).with(DEAD_LETTER_QUEUE_ROUTE_KEY);
  }
}
