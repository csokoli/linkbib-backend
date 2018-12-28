package com.csokoli.linkbib;

import com.csokoli.linkbib.domain.Site;
import com.csokoli.linkbib.repository.SiteRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class LinkbibliothekApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkbibliothekApplication.class, args);
    }

    @Bean
    ApplicationRunner init(SiteRepository siteRepository) {
        return args -> {
            Stream.of("Startseite", "Profiler", "eCampus")
                    .forEach(name -> {
                        Site site = new Site();
                        site.setName(name);
                        site.setDescription("Keine Beschreibung vorhanden");
                        siteRepository.save(site);
                    });
            siteRepository.findAll().forEach(System.out::println);
        };
    }
}

