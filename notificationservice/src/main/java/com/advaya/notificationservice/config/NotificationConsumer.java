package com.advaya.notificationservice.config;

import com.advaya.notificationservice.dtos.PaymentNotification;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private static final String TOPIC = "NOTIFICATION_TOPIC";

    @KafkaListener(topics = TOPIC, groupId = "notification-group")
    public void listen(PaymentNotification notification)
    {
        LOGGER.info("Notification Recieved "+notification);
    }


}
