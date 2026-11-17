package dev.asyl.portfolio.notifications;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotificationRepository extends JpaRepository<NotificationRecord,String>{}
