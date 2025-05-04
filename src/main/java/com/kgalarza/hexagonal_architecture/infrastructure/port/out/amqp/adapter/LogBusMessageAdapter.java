package com.kgalarza.hexagonal_architecture.infrastructure.port.out.amqp.adapter;

import com.kgalarza.hexagonal_architecture.domain.port.out.ILogBusMessagePort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogBusMessageAdapter implements ILogBusMessagePort {

    private final RabbitTemplate rabbitTemplate;

    @Value("${amqp.exchange.log}")
    private String exchange;

    @Value("${amqp.routing.key.log}")
    private String routingKey;

    public LogBusMessageAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchange,
                routingKey,
                message);
    }
}
