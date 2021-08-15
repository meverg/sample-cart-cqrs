package com.trendyol.notification.handler;

import com.trendyol.notification.model.Notification;
import com.trendyol.notification.service.NotificationService;
import event.notification.NotificationEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
@ProcessingGroup("notifications")
public class NotificationEventHandler {

  private final NotificationService notificationService;

  public NotificationEventHandler(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @EventSourcingHandler
  public void on(NotificationEvent event) {
    Notification notification = new Notification();
    notification.setMessage(event.getMessage());
    notificationService.sendEmailNotification(notification, event.getEmail());
  }
}
