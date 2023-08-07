package dev.ibreal.notification.controller;

import dev.ibreal.notification.dto.NotificationDTO;
import dev.ibreal.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.ibreal.notification.controller.NotificationController.NOTIFICATION_CONTROLLER_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping("${base-url}" + NOTIFICATION_CONTROLLER_PATH)
public class NotificationController {
    public static final String NOTIFICATION_CONTROLLER_PATH = "/notifications";
    private final NotificationService notificationService;

    @PostMapping
    public String notifyParticipants(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.notifyTelegramParticipants(notificationDTO);
    }
}
