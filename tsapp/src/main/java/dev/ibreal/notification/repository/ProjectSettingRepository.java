package dev.ibreal.notification.repository;

import dev.ibreal.notification.model.ProjectSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectSettingRepository extends JpaRepository<ProjectSetting, Long> {
    List<ProjectSetting> findByProjectId(Long projectId);
}
