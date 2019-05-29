package com.example.parts.configuration;

import com.example.parts.domain.Part;
import com.example.parts.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

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
            Part motherBoard = new Part("Mother Board", true, 4);
            Part soundCard = new Part("Sound Card", true, 2);
            Part cpu = new Part("CPU", true, 12);
            Part hdd = new Part("HDD", false, 41);
            Part ram = new Part("RAM", true, 4);
            Part ssd = new Part("SSD", true, 5);
            Part gpuCard = new Part("GPU card", false, 4);
            partRepository.saveAll(Arrays.asList(motherBoard, soundCard, cpu, hdd, ram, ssd, gpuCard));
        };
    }
}
