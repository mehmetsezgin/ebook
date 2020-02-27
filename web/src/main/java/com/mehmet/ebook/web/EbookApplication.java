package com.mehmet.ebook.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.mehmet.ebook.core")
@EntityScan(basePackages = "com.mehmet.ebook.core.entity")
@EnableJpaRepositories(basePackages = "com.mehmet.ebook.core.repository")
public class EbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbookApplication.class, args);
    }

}
