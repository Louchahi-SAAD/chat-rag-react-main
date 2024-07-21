package org.sid.chatrag;

import org.sid.chatrag.Repository.PersonRepository;
import org.sid.chatrag.entities.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class ChatRagApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(ChatRagApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository){
        return args -> {
            for (int i = 0; i < 100; i++){
                Person person = Person.builder()
                        .name(UUID.randomUUID().toString().substring(0, 8))
                        .email(UUID.randomUUID().toString().substring(0, 8) + "@gmail.com")
                        .build();
                personRepository.save(person);
            }
        };
    }

}
