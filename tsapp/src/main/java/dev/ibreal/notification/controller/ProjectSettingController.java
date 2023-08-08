package dev.ibreal.notification.controller;

import dev.ibreal.notification.dto.ProjectSettingDTO;
import dev.ibreal.notification.model.ProjectSetting;
import dev.ibreal.notification.repository.ProjectSettingRepository;
import dev.ibreal.notification.service.ProjectSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static dev.ibreal.notification.controller.ProjectSettingController.PROJECT_SETTING_CONTROLLER_PATH;

@RestController
@RequestMapping("${base-url}" + PROJECT_SETTING_CONTROLLER_PATH)
@RequiredArgsConstructor
public class ProjectSettingController {

    public static final String PROJECT_SETTING_CONTROLLER_PATH = "/project/settings";
    private final ProjectSettingRepository projectSettingRepository;
    private final ProjectSettingService projectSettingService;

    @PostMapping
    public ProjectSetting createProjectSetting(@RequestBody ProjectSettingDTO projectSettingDTO) {
        return projectSettingService.createProjectSetting(projectSettingDTO);
    }

    @GetMapping
    public List<ProjectSetting> getProjectsSettings() {
        return projectSettingRepository.findAll();
    }

}
