package acme.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final Logger log = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate<Integer, String> ktemplate;

    @Value("${app.topic}")
    private String topic;

    @GetMapping("/send")
    public SendInfo send(@RequestParam(value="msg") String message) {
        ktemplate.send(topic, message);
        log.info("Message sent to Kafka {}", message);
        return new SendInfo(topic, message);
    }

}
