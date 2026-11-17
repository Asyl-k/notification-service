package dev.asyl.portfolio.notifications;
public record NotificationMessage(String eventId,String recipient,String template,String payload){}
