package com.example.logaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LogaggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogaggregatorApplication.class, args);
	}

	@Bean
	public KafkaAdmin.NewTopics topics() {
		return new KafkaAdmin.NewTopics(
			TopicBuilder.name("logs-topic")
				.partitions(10)
				.build()
		);
	}
}
