package dev.ibreal.notification.service;

import dev.ibreal.notification.dto.NotificationDTO;
import dev.ibreal.notification.model.Project;
import dev.ibreal.notification.model.ProjectSetting;
import dev.ibreal.notification.repository.ProjectRepository;
import dev.ibreal.notification.repository.ProjectSettingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final TelegramBot telegramBot;
    private final ProjectRepository projectRepository;
    private final ProjectSettingRepository projectSettingRepository;

    @Override
    public String notifyTelegramParticipants(NotificationDTO notificationDTO) {
        String message = notificationDTO.getMessage();

        Project project = projectRepository.findByProjectId(notificationDTO.getProjectId());
        List<ProjectSetting> settings = getSettings(project.getId());

        settings.forEach(setting -> {
                    if (setting.getTelegramChatId() != null) {
                        telegramBot.sendMessage(setting.getTelegramChatId(), message);
                    }
                }
        );

        return "Notifications sent!";
    }

    private List<ProjectSetting> getSettings(Long projectId) {
        return projectSettingRepository.findByProjectId(projectId);
    }
}
