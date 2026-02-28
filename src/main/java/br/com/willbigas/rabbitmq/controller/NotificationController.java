package br.com.willbigas.springrabbitmq.controller;

import br.com.willbigas.springrabbitmq.producer.NotificationProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	private final NotificationProducer producer;

	public NotificationController(NotificationProducer producer) {
		this.producer = producer;
	}

	@PostMapping("/send")
    public String sendNotification(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {

        producer.sendNotification(to, subject, body);
        return "Notification queued successfully!";
    }
}
