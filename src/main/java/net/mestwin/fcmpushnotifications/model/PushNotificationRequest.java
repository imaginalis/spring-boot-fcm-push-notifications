package net.mestwin.fcmpushnotifications.model;

public class PushNotificationRequest {
    private String title;
    private String messageBody;
    private String topicName;
    private String token;

    public PushNotificationRequest(String title, String messageBody, String topicName) {
        this.title = title;
        this.messageBody = messageBody;
        this.topicName = topicName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
