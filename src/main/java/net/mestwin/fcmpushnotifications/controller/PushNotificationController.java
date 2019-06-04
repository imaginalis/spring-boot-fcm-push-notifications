package net.mestwin.fcmpushnotifications.controller;

import net.mestwin.fcmpushnotifications.firebase.FCMService;
import net.mestwin.fcmpushnotifications.model.PushNotificationRequest;
import net.mestwin.fcmpushnotifications.service.PushNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {
    private PushNotificationService pushNotificationService;
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/send")
    public ResponseEntity sendNotification(PushNotificationRequest request) {
        pushNotificationService.sendPushNotification(request);
        return ResponseEntity.ok("A notification has been sent.");
    }

    @GetMapping("/send-sample")
    public ResponseEntity sendSampleNotification(PushNotificationRequest request) {
        pushNotificationService.sendSamplePushNotification();
        return ResponseEntity.ok("A notification has been sent.");
    }
}
