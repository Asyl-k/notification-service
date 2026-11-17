package dev.asyl.portfolio.notifications;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="notification_events")
public class NotificationRecord {
    @Id @Column(length=120)
    private String eventId;
    @Column(nullable=false,length=320)
    private String recipient;
    @Column(nullable=false,length=100)
    private String template;
    @Lob @Column(nullable=false)
    private String payload;
    @Enumerated(EnumType.STRING) @Column(nullable=false,length=20)
    private NotificationStatus status=NotificationStatus.ACCEPTED;
    @Column(nullable=false,updatable=false)
    private Instant receivedAt=Instant.now();
    protected NotificationRecord(){}
    public NotificationRecord(NotificationMessage message){
        if(message.eventId()==null||message.eventId().isBlank())throw new IllegalArgumentException("eventId is required");
        this.eventId=message.eventId();this.recipient=message.recipient();this.template=message.template();this.payload=message.payload();
    }
    public String getEventId(){return eventId;}
    public String getRecipient(){return recipient;}
    public String getTemplate(){return template;}
    public String getPayload(){return payload;}
    public NotificationStatus getStatus(){return status;}
    public Instant getReceivedAt(){return receivedAt;}
    public void markDelivered(){status=NotificationStatus.DELIVERED;}
    public void markFailed(){status=NotificationStatus.FAILED;}
}
