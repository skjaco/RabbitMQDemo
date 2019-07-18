package com.sk.service.serviceImpl;

import com.sk.config.SendConfig;
import com.sk.service.TopicService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send1(String msg) {
        System.out.println("路由键 topic.message.rabbit 发送消息："+msg);
        rabbitTemplate.convertAndSend(SendConfig.TOPIC_EXCHANGE, "topic.message.rabbit", msg);
    }

    @Override
    public void send2(String msg) {
        System.out.println("路由键 topic.message.kafka 发送消息："+msg);
        rabbitTemplate.convertAndSend(SendConfig.TOPIC_EXCHANGE, "topic.message.kafka", msg);
    }

    @Override
    public void send3(String msg) {
        System.out.println("路由键 topic 发送消息："+msg);
        rabbitTemplate.convertAndSend(SendConfig.TOPIC_EXCHANGE, "topic", msg);
    }
}
