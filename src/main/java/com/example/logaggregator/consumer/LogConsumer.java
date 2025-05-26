package com.example.logaggregator.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.logaggregator.service.LogProcessingService;

@Service
public class LogConsumer {
  
  private LogProcessingService logProcessingService;
  
  public LogConsumer(LogProcessingService logProcessingService) {
    this.logProcessingService = logProcessingService;
  }
  
  @KafkaListener(
    id = "logConsumer",
    topics = "logs-topic",
    groupId = "log-aggregator-group",
    concurrency = "3"
  )
  public void consume(ConsumerRecord<String, String> record) {
    logProcessingService.processLog(record.value());
  }
}
