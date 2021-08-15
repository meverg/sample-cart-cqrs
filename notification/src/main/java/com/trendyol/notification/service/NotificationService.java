package com.trendyol.notification.service;

import com.trendyol.notification.model.Notification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
public class NotificationService {

  private static final String NOREPLY_ADDRESS = "noreply@hedwig.com";

  private final JavaMailSender mailSender;

  public NotificationService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void sendEmailNotification(Notification notification, String emailAddress) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(NOREPLY_ADDRESS);
    message.setTo(emailAddress);
    message.setSubject("");
    message.setText(notification.getMessage());
    mailSender.send(message);
  }
}
