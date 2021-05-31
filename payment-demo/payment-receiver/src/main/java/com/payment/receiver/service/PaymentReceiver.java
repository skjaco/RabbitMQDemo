package com.payment.receiver.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * TODO
 *
 * @author songke
 * @version 1.0.0
 * @since 2021/05/19 16:15
 */
@Component
public class PaymentReceiver {
  private static Integer timer=0;
  @RabbitListener(queues = {"delay.queue.1", "delay.queue.2", "delay.queue.3"})
  public void receivePayment(Message message, Channel channel) throws IOException {
    System.out.println("接收到["+message.getMessageProperties().getConsumerQueue()+"]的消息：" + new String(message.getBody()));
    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
  }
}
