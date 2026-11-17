package dev.asyl.portfolio.notifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {
    private final NotificationRepository repository;
    public NotificationService(NotificationRepository repository){this.repository=repository;}
    @Transactional
    public boolean accept(NotificationMessage message){
        if(message.eventId()==null||message.eventId().isBlank())throw new IllegalArgumentException("eventId is required");
        if(repository.existsById(message.eventId()))return false;
        repository.save(new NotificationRecord(message));
        return true;
    }
}
