package com.acilia.ttschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ComponentScan(basePackages="com.acilia")
public class TtSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtSchoolApplication.class, args);
	}
}
