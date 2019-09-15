package acme.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger log = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${app.topic}")
    public void listen(String message) {
        log.info("Message received: {}", message);
    }

}
