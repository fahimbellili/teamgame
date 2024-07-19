package com.fbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.fbe.*")
public class TeamGameApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamGameApplication.class);
    }
}
