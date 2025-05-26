package com.example.logaggregator.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogProcessingService {
  
  @Async("logProcessorExecutor")
  public void processLog(String logMessage) {
    System.out.printf("🛠️ [Thread: %s] Processing log: %s%n",
      Thread.currentThread().getName(), logMessage);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      System.out.printf("✅ [Thread: %s] Done processing: %s%n",
        Thread.currentThread().getName(), logMessage);
  }

}
