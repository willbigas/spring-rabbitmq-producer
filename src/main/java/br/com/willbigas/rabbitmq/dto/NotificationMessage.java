package br.com.willbigas.springrabbitmq.dto;

import java.io.Serializable;

public record NotificationMessage(String to, String subject, String body) implements Serializable {
}
