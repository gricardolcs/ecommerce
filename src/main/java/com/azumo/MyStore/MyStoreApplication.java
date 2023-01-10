package com.azumo.MyStore;

import com.azumo.MyStore.common.events.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyStoreApplication {

	public static void main(String[] args) {
        SpringApplication.run(MyStoreApplication.class, args);
	}

    @Bean
    EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return applicationEventPublisher::publishEvent;
    }

}
