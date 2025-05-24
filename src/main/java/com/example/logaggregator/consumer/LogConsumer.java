package com.example.logaggregator.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
  
  @KafkaListener(
    id = "logConsumer",
    topics = "logs-topic",
    groupId = "log-aggregator-group",
    concurrency = "3"
  )
  public void consume(ConsumerRecord<String, String> record) {
    System.out.printf("🔥 [Thread: %s] Received log: key=%s, value=%s, partition=%d, offset=%d%n",
      Thread.currentThread().getName(), record.key(), record.value(), record.partition(), record.offset());
  }
}
