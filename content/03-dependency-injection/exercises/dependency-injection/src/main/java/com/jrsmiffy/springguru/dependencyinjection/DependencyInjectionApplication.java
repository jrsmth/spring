package com.jrsmiffy.springguru.dependencyinjection;

import com.jrsmiffy.springguru.dependencyinjection.controller.ConversationController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication @Slf4j
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		ConversationController controller = (ConversationController) ctx.getBean("conversationController");
		// note: Spring automatically loads our class into app ctx due to the @Controller annotation
		String greeting = controller.sayHello();

		log.info(greeting);

	}

}
