package dev.asyl.portfolio.notifications;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {
    @Mock NotificationRepository repository;
    @InjectMocks NotificationService service;
    @Test void acceptsNewEventOnce(){
        var event=new NotificationMessage("evt-1","user@example.test","order-confirmed","{}");
        when(repository.existsById("evt-1")).thenReturn(false);
        assertTrue(service.accept(event));
        verify(repository).save(any(NotificationRecord.class));
    }
    @Test void ignoresDuplicateDelivery(){
        when(repository.existsById("evt-1")).thenReturn(true);
        assertFalse(service.accept(new NotificationMessage("evt-1","a@b.test","template","{}")));
        verify(repository,never()).save(any());
    }
    @Test void rejectsMissingEventId(){
        assertThrows(IllegalArgumentException.class,()->service.accept(new NotificationMessage(" ","a@b.test","t","{}")));
        verifyNoInteractions(repository);
    }
}
