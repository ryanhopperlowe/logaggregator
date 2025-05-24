package com.example.logaggregator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logaggregator.producer.LogProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/logs")
public class LogController {
  private final LogProducer logProducer;

  public LogController(LogProducer logProducer) {
    this.logProducer = logProducer;
  }

  @PostMapping
  public String postLog(@RequestBody String logMessage) {
    this.logProducer.sendLog(logMessage);
    return "Log sent to Kafka";
  }
}
