package net.mestwin.fcmpushnotifications.firebase;

import com.google.firebase.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FCMClient {
    private final String TOPIC = "contactTopic";
    Logger logger = LoggerFactory.getLogger(FCMClient.class);

    @Scheduled(initialDelay=60000, fixedDelay = 60000)
    public void sendPushMessage() {
        Map<String, String> pushData = new HashMap<>();
        //pushData.put("id", String.valueOf(id++));
        //pushData.put("text", "hello hello hello " + id);
        try {
            sendTest(pushData);
        }
        catch (InterruptedException | ExecutionException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendTest(Map<String,String> data)
            throws InterruptedException, ExecutionException {
        AndroidConfig androidConfig = getAndroidConfig();
        ApnsConfig apnsConfig = getApnsConfig();
        Message message = getMessage(data, androidConfig, apnsConfig);
        String response = FirebaseMessaging.getInstance().sendAsync(message).get();
        logger.info("Sent message.");
    }

    private AndroidConfig getAndroidConfig() {
        return AndroidConfig.builder()
                    .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(TOPIC)
                    .setPriority(AndroidConfig.Priority.HIGH)
                    .setNotification(AndroidNotification.builder().setSound(NotificationParameter.SOUND.getValue())
                            .setColor(NotificationParameter.COLOR.getValue()).setTag(TOPIC).build()).build();
    }

    private ApnsConfig getApnsConfig() {
        return ApnsConfig.builder()
                    .setAps(Aps.builder().setCategory(TOPIC).setThreadId(TOPIC).build()).build();
    }

    private Message getMessage(Map<String, String> data, AndroidConfig androidConfig, ApnsConfig apnsConfig) {
        return Message.builder().putAllData(data).setTopic(TOPIC)
                    .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig)
                    .setNotification(
                            new Notification("Contact topic - Hello", "Sending scheduled test message ✔\uD83D\uDE42 " + LocalDateTime.now()))
                    .build();
    }


}
