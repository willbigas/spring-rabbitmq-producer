package br.com.willbigas.rabbitmq.producer;

import br.com.willbigas.rabbitmq.config.NotificationQueueConfig;
import br.com.willbigas.rabbitmq.dto.NotificationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

	public NotificationProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendNotification(String to, String subject, String body) {
        NotificationMessage message = new NotificationMessage(to, subject, body);

        System.out.println("Sending: " + message);

        rabbitTemplate.convertAndSend(
            NotificationQueueConfig.EXCHANGE_NAME,
            NotificationQueueConfig.ROUTING_KEY,
            message
        );

        System.out.println("Message sent successfully!");
    }
}
