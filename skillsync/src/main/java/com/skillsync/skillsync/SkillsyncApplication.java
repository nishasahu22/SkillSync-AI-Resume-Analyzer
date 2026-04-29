package com.skillsync.skillsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.skillsync.skillsync")
public class
SkillsyncApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkillsyncApplication.class, args);
	}
}
