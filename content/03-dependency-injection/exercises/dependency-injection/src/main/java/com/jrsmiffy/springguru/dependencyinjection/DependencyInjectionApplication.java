package com.jrsmiffy.springguru.dependencyinjection;

import com.jrsmiffy.springguru.dependencyinjection.controller.*;
import com.jrsmiffy.springguru.dependencyinjection.pet.PetController;
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

		/** Showcasing DI with the Spring Framework (non-manual) */
		log.info("--- Showcasing DI with the Spring Framework (non-manual) ---");

		log.info("--- P R O P E R T Y ---");
		PropertyInjectedController propertyController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		log.info(propertyController.getGreeting());

		log.info("--- S E T T E R ---");
		SetterInjectedController setterController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		log.info(setterController.getGreeting());

		log.info("--- C O N S T R U C T O R ---");
		ConstructorInjectedController constructorController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		log.info(constructorController.getGreeting());

		/** Showcasing @Primary */
		log.info("--- Showcasing @Primary ---");
		log.info(controller.getGreeting());

		/** Showcasing Spring Profiles */
		log.info("--- Showcasing Spring Profiles ---");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		log.info(i18nController.welcome());
		// note: this will welcome() in English or Spanish, depending on the profile set in app.prop

		/** D.I Assignment :: Favourite Pet */
		log.info("--- D.I Assignment :: Favourite Pet ---");
		PetController petController = ctx.getBean("petController", PetController.class);
		log.info("The best pet is {}", petController.getFavouritePetType());

	}

}
