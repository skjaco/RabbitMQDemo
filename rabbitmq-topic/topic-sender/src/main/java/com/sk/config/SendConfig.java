package com.sk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SendConfig {
    public static final String TOPIC_QUEUE_1 = "topic.queue.1";
    public static final String TOPIC_QUEUE_2 = "topic.queue.2";
    public static final String TOPIC_QUEUE_3 = "topic.queue.3";
    public static final String TOPIC_EXCHANGE = "topic.exchange";
    public static final String TOPIC_ROUTING_KEY_1 = "topic.message.rabbit";
    public static final String TOPIC_ROUTING_KEY_2 = "topic.message.*";
    public static final String TOPIC_ROUTING_KEY_3 = "topic.#";

    @Bean
    public Queue queue1() {
        return new Queue(TOPIC_QUEUE_1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(TOPIC_QUEUE_2);
    }

    @Bean
    public Queue queue3() {
        return new Queue(TOPIC_QUEUE_3);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with(TOPIC_ROUTING_KEY_1);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with(TOPIC_ROUTING_KEY_2);
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(topicExchange()).with(TOPIC_ROUTING_KEY_3);
    }

}
