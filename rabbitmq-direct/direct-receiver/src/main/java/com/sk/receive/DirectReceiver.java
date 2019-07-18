package com.sk.receive;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {
    @RabbitListener(queues = "direct.queue.1")
    public void receiveDirect1(String msg) {
        System.out.println("接收到direct.queue.1的消息：" + msg);
    }

    @RabbitListener(queues = "direct.queue.2")
    public void receiveDirect2(String msg) {
        System.out.println("接收到direct.queue.2的消息：" + msg);
    }
}
