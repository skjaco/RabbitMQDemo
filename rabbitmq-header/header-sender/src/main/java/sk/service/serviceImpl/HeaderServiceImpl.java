package sk.service.serviceImpl;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.config.SendConfig;
import sk.service.HeaderService;

@Service
public class HeaderServiceImpl implements HeaderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send1(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue1");
        messageProperties.setHeader("bindType", "whereAll");
        Message message = new Message(msg.getBytes(), messageProperties);
        System.out.println("发送消息："+msg);
        rabbitTemplate.convertAndSend(SendConfig.HEADER_EXCHANGE, null, message);
    }

    @Override
    public void send2(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue2");
        messageProperties.setHeader("bindType", "whereAny");
        Message message = new Message(msg.getBytes(), messageProperties);
        System.out.println("发送消息："+msg);
        rabbitTemplate.convertAndSend(SendConfig.HEADER_EXCHANGE, null, message);

    }
}
