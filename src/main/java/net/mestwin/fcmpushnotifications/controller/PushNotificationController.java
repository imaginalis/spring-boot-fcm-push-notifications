package net.mestwin.fcmpushnotifications.controller;

import net.mestwin.fcmpushnotifications.firebase.FCMClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {
    private FCMClient fcmClient;
    public PushNotificationController(FCMClient fcmClient) {
        this.fcmClient = fcmClient;
    }

    @GetMapping("/send")
    public ResponseEntity sendNotification() {
        fcmClient.sendPushMessage();
        return ResponseEntity.ok("A notification has been sent.");
    }
}
