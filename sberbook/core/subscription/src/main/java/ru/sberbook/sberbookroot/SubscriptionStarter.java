package ru.sberbook.sberbookroot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SubscriptionStarter {
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionStarter.class, args);
	}
}
