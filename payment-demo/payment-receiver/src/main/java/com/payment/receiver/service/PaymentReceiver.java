package com.payment.receiver.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
  @RabbitListener(queues = {"delay.queue.1"})
  public void receiveQueue1Payment(Message message, Channel channel) throws IOException {
    System.out.println("接收到["+message.getMessageProperties().getConsumerQueue()+"]的消息：" + new String(message.getBody()));
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
  }
  @RabbitListener(queues = {"delay.queue.2"})
  public void receiveQueue2Payment(Message message, Channel channel) throws IOException {
    System.out.println("接收到[" + message.getMessageProperties().getConsumerQueue()+"]的消息：" + new String(message.getBody()));
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
  }
  @RabbitListener(queues = {"delay.queue.3"})
  public void receiveQueue3Payment(Message message, Channel channel) throws IOException {
    System.out.println("接收到["+message.getMessageProperties().getConsumerQueue()+"]的消息：" + new String(message.getBody()));
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
  }
}
