package dev.ibreal.notification.dto;

import dev.ibreal.notification.NotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectSettingDTO {
    private Long projectId;
    private NotificationType notificationType;
    // telegram setting
    private String groupChatId;
}
