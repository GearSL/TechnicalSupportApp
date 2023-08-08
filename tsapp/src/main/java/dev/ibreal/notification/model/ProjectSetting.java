package dev.ibreal.notification.model;

import dev.ibreal.notification.NotificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "project_settings")
public class ProjectSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Project project;
    private NotificationType notificationType;
    @Column(unique = true)
    private String telegramChatId;
}
