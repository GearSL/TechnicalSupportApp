package dev.ibreal.notification.controller;

import dev.ibreal.notification.dto.ProjectDTO;
import dev.ibreal.notification.model.Project;
import dev.ibreal.notification.repository.ProjectRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dev.ibreal.notification.controller.ProjectController.PROJECT_CONTROLLER_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping("${base-url}" + PROJECT_CONTROLLER_PATH)
public class ProjectController {
    public static final String PROJECT_CONTROLLER_PATH = "/projects";
    private final ProjectRepository projectRepository;

    @PostMapping
    public Project createProject(@RequestBody @Valid ProjectDTO projectDTO) {
        return projectRepository.save(new Project(projectDTO.getProjectId()));
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
