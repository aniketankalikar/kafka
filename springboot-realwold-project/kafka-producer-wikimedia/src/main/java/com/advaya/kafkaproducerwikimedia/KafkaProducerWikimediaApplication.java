package com.advaya.kafkaproducerwikimedia;

import kafka.WikimediaChangesProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication(scanBasePackages = {"com.advaya.kafkaproducerwikimedia", "kafka"})
public class KafkaProducerWikimediaApplication implements CommandLineRunner {

    private WikimediaChangesProducer wikimediaChangesProducer;


    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
    }

   @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }
}
