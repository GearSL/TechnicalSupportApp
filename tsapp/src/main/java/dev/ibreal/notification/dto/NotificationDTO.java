package dev.ibreal.notification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {
    private String projectId;
    private String ticketId;
    private String status;
    private String responsible;
    private String message;
}
