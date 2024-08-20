package com.advaya.kafkaconsumerwikimedia.kafka;

import com.advaya.kafkaconsumerwikimedia.model.WikimediaData;
import com.advaya.kafkaconsumerwikimedia.repositories.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository)
    {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recent_change",groupId = "mygroup")
    public void consume(String eventMessage)

    {
        LOGGER.info(String.format("Event Message Recieved %s",eventMessage));
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(data);


    }

}
