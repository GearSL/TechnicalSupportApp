package dev.ibreal.notification.service;

import dev.ibreal.notification.dto.NotificationDTO;

public interface NotificationService {
    String notifyTelegramParticipants(NotificationDTO notificationDTO);
}
