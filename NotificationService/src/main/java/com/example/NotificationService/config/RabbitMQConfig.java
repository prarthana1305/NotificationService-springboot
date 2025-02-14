package com.example.NotificationService.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "notification.exchange";
    public static final String PAYMENT_SUCCESS_ROUTING_KEY = "payment.success";
    public static final String PENALTY_ROUTING_KEY = "penalty.charged";
    public static final String SOS_ROUTING_KEY = "metro.sos";

    @Bean
    public TopicExchange notificationExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue paymentSuccessQueue() {
        return new Queue("notification.payment.success.queue");
    }

    @Bean
    public Queue penaltyQueue() {
        return new Queue("notification.penalty.queue");
    }

    @Bean
    public Queue sosQueue() {
        return new Queue("notification.sos.queue");
    }

    @Bean
    public Binding bindingPaymentSuccess(Queue paymentSuccessQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(paymentSuccessQueue).to(notificationExchange).with(PAYMENT_SUCCESS_ROUTING_KEY);
    }

    @Bean
    public Binding bindingPenalty(Queue penaltyQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(penaltyQueue).to(notificationExchange).with(PENALTY_ROUTING_KEY);
    }

    @Bean
    public Binding bindingSOS(Queue sosQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(sosQueue).to(notificationExchange).with(SOS_ROUTING_KEY);
    }

    // Configure JSON message converter for RabbitMQ messages
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
