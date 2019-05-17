package ru.sberbook.sberbookroot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AuthorizationStarter {
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationStarter.class, args);
	}
}
