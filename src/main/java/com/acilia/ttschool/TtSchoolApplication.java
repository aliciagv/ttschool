package com.acilia.ttschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="com.acilia")
public class TtSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtSchoolApplication.class, args);
	}
}
