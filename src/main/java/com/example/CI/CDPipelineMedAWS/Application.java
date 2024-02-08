package com.example.CI.CDPipelineMedAWS;

import com.example.CI.CDPipelineMedAWS.client.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Menu menu = context.getBean(Menu.class);
		menu.displayMenu();
	}

}
