package dev.asyl.portfolio.notifications;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
    private final NotificationService service;
    public NotificationConsumer(NotificationService service){this.service=service;}
    @KafkaListener(topics="${app.kafka.topic:notification-events}",groupId="${spring.kafka.consumer.group-id}")
    public void onMessage(NotificationMessage message){service.accept(message);}
}
