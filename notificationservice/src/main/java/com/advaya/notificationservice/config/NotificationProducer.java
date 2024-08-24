package com.advaya.notificationservice.config;

import com.advaya.notificationservice.dtos.PaymentNotification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProducer.class);

    private KafkaTemplate<String, PaymentNotification> kafkaTemplate;
    private static final String TOPIC = "NOTIFICATION_TOPIC";

    public NotificationProducer(KafkaTemplate<String, PaymentNotification> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(PaymentNotification notification)
    {
        LOGGER.info("Notification message sent to Kafka Topic "+notification);
        kafkaTemplate.send(TOPIC,notification);
    }

}
