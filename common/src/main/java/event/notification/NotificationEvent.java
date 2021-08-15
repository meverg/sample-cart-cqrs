package event.notification;

import java.util.Objects;

/**
 * @author meverg
 */
public class NotificationEvent {

  private final String message;

  private final String email;

  public NotificationEvent(String message, String email) {
    this.message = message;
    this.email = email;
  }

  public String getMessage() {
    return message;
  }

  public String getEmail() {
    return email;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NotificationEvent that = (NotificationEvent) o;
    return Objects.equals(message, that.message) && Objects.equals(email, that.email);
  }

  @Override public int hashCode() {
    return Objects.hash(message, email);
  }

  @Override public String toString() {
    return "NotificationEvent{" +
           "message='" + message + '\'' +
           ", email='" + email + '\'' +
           '}';
  }
}
