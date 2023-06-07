package com.example.jpa;

import com.example.jpa.models.Business;
import com.example.jpa.models.Person;
import com.example.jpa.models.Role;
import com.example.jpa.repository.BusinessRepository;
import com.example.jpa.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MossioJpaApplication implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final BusinessRepository businessRepository;

    public static void main(String[] args) {
        SpringApplication.run(MossioJpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Person john = Person.builder()
                .name("Antony")
                .role(Role.USER)
                .email("antony@gmail.com")
                .build();

        personRepository.save(john);

        Person andrea = Person.builder()
                .name("Andrea")
                .role(Role.ADMIN)
                .email("andrea@gmail.com")
                .build();

        personRepository.save(andrea);

        Business business = Business.builder()
                .name("Drogaria Mossio")
                .owner(john)
                .employees(List.of(john, andrea))
                .build();

        businessRepository.save(business);
    }
}
