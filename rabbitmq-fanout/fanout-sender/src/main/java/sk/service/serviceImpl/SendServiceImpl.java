package sk.service.serviceImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.config.SendConfig;
import sk.service.SendService;

@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String msg) {
        System.out.println("Fanout发送数据：" + msg);
        rabbitTemplate.convertAndSend(SendConfig.FANOUT_EXCHANGE, "", msg);
    }
}
