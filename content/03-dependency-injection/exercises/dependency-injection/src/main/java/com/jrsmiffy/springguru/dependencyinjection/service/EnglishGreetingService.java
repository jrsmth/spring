package com.jrsmiffy.springguru.dependencyinjection.service;

import com.jrsmiffy.springguru.dependencyinjection.repository.EnglishGreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("english")
//@Service("i18nService") // note: this renames the bean - used for demo purposes to conflict with SpanishGreetingService
// note: ^removed the stereotype annotation to make use of @Configuration (Section 5: Spring Configuration)
@RequiredArgsConstructor // note: Section 5: Spring Configuration
public class EnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository repository;
    // note: ^added to demonstrate D.I with Java-based Config (Section 5: Spring Configuration)

    /** note: removed to demonstrate D.I with Java-based Config (Section 5: Spring Configuration)
      @Override
      public String sayGreeting() {
          return "A warm welcome from the English";
      }
    */

    public String sayGreeting() {
        return repository.sayGreeting();
    }

}
