package dev.ibreal.notification.service;

import dev.ibreal.notification.dto.NotificationDTO;
import dev.ibreal.notification.model.Project;
import dev.ibreal.notification.model.ProjectSetting;
import dev.ibreal.notification.repository.ProjectRepository;
import dev.ibreal.notification.repository.ProjectSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final TelegramBot telegramBot;
    private final ProjectRepository projectRepository;
    private final ProjectSettingRepository projectSettingRepository;

    @Override
    public String notifyTelegramParticipants(NotificationDTO notificationDTO) {
        String messageTemplate = """
                🔑<b>Ticket:</b> %s  \n
                📍<b>Status:</b> %s \n
                📝<b>Message:</b> %s \n
                👨‍💻<b>Responsible:</b> %s \n
                """;
        String filledMessage = String.format(messageTemplate,
                notificationDTO.getTicketId(),
                notificationDTO.getStatus(),
                notificationDTO.getMessage(),
                notificationDTO.getResponsible()
                );

        Project project = projectRepository.findByProjectId(notificationDTO.getProjectId());
        List<ProjectSetting> settings = getSettings(project.getId());
        settings.forEach(setting -> {
                    if (setting.getTelegramChatId() != null) {
                        telegramBot.sendMessage(setting.getTelegramChatId(), filledMessage);
                    }
                }
        );

        return "Notifications sent!";
    }

    private List<ProjectSetting> getSettings(Long projectId) {
        return projectSettingRepository.findAll();
    }
}
