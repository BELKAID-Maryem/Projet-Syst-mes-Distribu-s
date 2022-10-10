package com.example.emplacementservice;

import com.example.emplacementservice.Repository.EmplacementRepository;
import com.example.emplacementservice.entitie.Emplacement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmplacementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmplacementServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EmplacementRepository emplacementRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Emplacement.class);
            emplacementRepository.save(new Emplacement(null , "Emplacement 1"));
            emplacementRepository.save(new Emplacement(null , "Emplacement 2"));
            emplacementRepository.save(new Emplacement(null , "Emplacement 3"));
            emplacementRepository.save(new Emplacement(null , "Emplacement 4"));
            emplacementRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }
}
