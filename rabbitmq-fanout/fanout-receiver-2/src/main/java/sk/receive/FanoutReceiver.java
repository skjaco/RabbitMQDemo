package sk.receive;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    @Value("${server.port}")
    private String port;

    @RabbitListener(queues = "fanout.queue.2")
    public void receiveDirect1(String msg) {
        System.out.println(port + "接收到fanout的消息：" + msg);
    }
}
