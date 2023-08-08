package dev.ibreal.notification.service;

import dev.ibreal.notification.dto.ProjectSettingDTO;
import dev.ibreal.notification.model.ProjectSetting;

public interface ProjectSettingService {
    ProjectSetting createProjectSetting(ProjectSettingDTO projectSettingDTO);
}
