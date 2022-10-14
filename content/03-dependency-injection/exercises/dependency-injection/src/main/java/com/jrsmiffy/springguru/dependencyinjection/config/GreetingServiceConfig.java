package com.jrsmiffy.springguru.dependencyinjection.config;

import com.jrsmiffy.springguru.dependencyinjection.repository.EnglishGreetingRepository;
import com.jrsmiffy.springguru.dependencyinjection.repository.EnglishGreetingRepositoryImpl;
import com.jrsmiffy.springguru.dependencyinjection.service.EnglishGreetingService;
import com.jrsmiffy.springguru.dependencyinjection.service.PrimaryGreetingService;
import com.jrsmiffy.springguru.dependencyinjection.service.SpanishGreetingService;
import com.jrsmiffy.springguru.pet.PetService;
import com.jrsmiffy.springguru.pet.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:dependencyinjection-config.xml")
// note: ^this tells Spring where our XML-defined beans are; could also be used on @SpringBootApplication main class
@Configuration // note: tells Spring that we are defining Beans here
public class GreetingServiceConfig {

    @Bean // note: the method name here drives the Bean name in the Spring Context ("petServiceFactory")
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean @Profile({"dog", "default"})
    PetService dogService(PetServiceFactory petServiceFactory) { // note: showcasing factory beans
        return petServiceFactory.getPetService("dog");
    }

    @Bean @Profile("cat")
    PetService catService(PetServiceFactory petServiceFactory) { // note: showcasing factory beans
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("english")
    @Bean("i18nService") // note: this renames the bean - used for demo purposes to conflict with SpanishGreetingService
    EnglishGreetingService englishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        return new EnglishGreetingService(englishGreetingRepository); // note: demo for D.I with Java-based Config
    }

    @Profile("spanish")
    @Bean("i18nService") // note: this renames the bean - used for demo purposes to conflict with EnglishGreetingService
    SpanishGreetingService spanishGreetingService() {
        return new SpanishGreetingService();
    }

    @Bean @Primary
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    /** @Bean // note: This Bean is now defined in XML configuration, as part of [05-77] "XML Configuration"
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }
    */

}
