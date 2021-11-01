package com.rostertwo.commandLineAppplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandLineAppplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandLineAppplicationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(){
		return args -> {
			System.out.println("hello world");
		};
	}
}
