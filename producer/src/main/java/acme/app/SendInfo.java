package acme.app;

public class SendInfo {

    private final String topic;
    private final String message;

    public SendInfo(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() { return topic; }
    public String getContent() { return message; }
}
