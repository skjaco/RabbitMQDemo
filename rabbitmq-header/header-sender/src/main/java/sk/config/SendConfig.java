package sk.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SendConfig {
    public static final String HEADER_QUEUE_1 = "header.queue.1";
    public static final String HEADER_QUEUE_2 = "header.queue.2";
    public static final String HEADER_EXCHANGE = "header.exchange";

    @Bean
    public Queue queue1() {
        return new Queue(HEADER_QUEUE_1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(HEADER_QUEUE_2);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(HEADER_EXCHANGE);
    }

    @Bean
    public Binding binding1() {
        HashMap<String, Object> header = new HashMap<>();
        header.put("queue", "queue1");
        header.put("bindType", "whereAll");
        return BindingBuilder.bind(queue1()).to(headersExchange()).whereAll(header).match();
    }

    @Bean
    public Binding binding2() {
        HashMap<String, Object> header = new HashMap<>();
        header.put("queue", "queue2");
        header.put("bindType", "whereAny");
        return BindingBuilder.bind(queue2()).to(headersExchange()).whereAny(header).match();
    }
}
