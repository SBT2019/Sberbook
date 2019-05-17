package ru.sberbook.sberbookroot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscoveryStarter {
	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryStarter.class, args);
	}
}
