package com.example.parts.configuration;

import com.example.parts.domain.Part;
import com.example.parts.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    private final PartRepository partRepository;

    @Autowired
    public DatabaseConfiguration(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Part motherBoard = new Part("MotherBoard", true, 4);
            partRepository.save(motherBoard);
        };
    }
}
