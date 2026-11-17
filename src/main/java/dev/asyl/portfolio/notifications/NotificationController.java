package dev.asyl.portfolio.notifications;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationRepository repository;
    public NotificationController(NotificationRepository repository){this.repository=repository;}
    @GetMapping public List<NotificationRecord> findAll(){return repository.findAll();}
    @GetMapping("/{eventId}") public NotificationRecord find(@PathVariable String eventId){
        return repository.findById(eventId).orElseThrow(()->new NotificationNotFoundException(eventId));
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class NotificationNotFoundException extends RuntimeException{
        public NotificationNotFoundException(String id){super("Notification event not found: "+id);}
    }
}
