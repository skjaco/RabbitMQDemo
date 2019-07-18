package com.sk.service.serviceImpl;

import com.sk.config.SendConfig;
import com.sk.service.DirectSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectSendServiceImpl implements DirectSendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendQueue1(String msg) {
        System.out.println("发送到队列1：" + msg);
        rabbitTemplate.convertAndSend(SendConfig.DIRECT_EXCHANGE, SendConfig.DIRECT_ROUTE_KEY_1, msg);
    }

    @Override
    public void sendQueue2(String msg) {
        System.out.println("发送到队列2：" + msg);
        rabbitTemplate.convertAndSend(SendConfig.DIRECT_EXCHANGE, SendConfig.DIRECT_ROUTE_KEY_2, msg);
    }
}
