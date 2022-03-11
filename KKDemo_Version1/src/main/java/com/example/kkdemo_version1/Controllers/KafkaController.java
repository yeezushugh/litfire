package com.example.kkdemo_version1.Controllers;

import com.example.kkdemo_version1.Component.KafkaConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;
    private KafkaConsumer kafkaConsumer;

    public KafkaController(KafkaTemplate<String, String> template, KafkaConsumer kafkaConsumer) {
        this.template = template;
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("Test", message);
    }

    @GetMapping("/kafka/consume")
    public List<String> consume(@RequestParam String message) {
        return kafkaConsumer.getMessages();
    }

}