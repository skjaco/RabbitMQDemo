package com.sk.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive {

    @RabbitListener(queues = "topic.queue.1")
    public void receiveTopic1(String msg) {
        System.out.println("topic.queue.1 接收到数据：" + msg);
    }

    @RabbitListener(queues = "topic.queue.2")
    public void receiveTopic2(String msg) {
        System.out.println("topic.queue.2 接收到数据：" + msg);
    }

    @RabbitListener(queues = "topic.queue.3")
    public void receiveTopic3(String msg) {
        System.out.println("topic.queue.3 接收到数据：" + msg);
    }
}
