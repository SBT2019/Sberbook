package ru.sberbook.sberbookroot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.service.ProfileServiceImpl;

@SpringBootApplication
public class ProfileStarter {
	public static void main(String[] args) {
		SpringApplication.run(ProfileStarter.class, args);
	}
}
