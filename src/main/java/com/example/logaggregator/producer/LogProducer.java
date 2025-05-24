package com.example.logaggregator.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducer {
  private final KafkaTemplate<String, String> kafkaTemplate;

  public LogProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendLog(String logMessage) {
    this.kafkaTemplate.send("logs-topic", logMessage);
  }
}
