package dev.ibreal.notification.service;

import dev.ibreal.notification.dto.ProjectSettingDTO;
import dev.ibreal.notification.model.Project;
import dev.ibreal.notification.model.ProjectSetting;
import dev.ibreal.notification.repository.ProjectRepository;
import dev.ibreal.notification.repository.ProjectSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectSettingServiceImpl implements ProjectSettingService {
    private final ProjectRepository projectRepository;
    private final ProjectSettingRepository projectSettingRepository;

    @Override
    public ProjectSetting createProjectSetting(ProjectSettingDTO projectSettingDTO) {
        Project project = projectRepository.findById(projectSettingDTO.getProjectId()).orElseThrow();
        ProjectSetting projectSetting = new ProjectSetting();
        projectSetting.setProject(project);
        projectSetting.setNotificationType(projectSettingDTO.getNotificationType());
        projectSetting.setTelegramChatId(projectSettingDTO.getGroupChatId());
        return projectSettingRepository.save(projectSetting);
    }

}
