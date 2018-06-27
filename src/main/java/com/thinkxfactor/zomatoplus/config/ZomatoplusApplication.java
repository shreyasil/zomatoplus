
package com.thinkxfactor.zomatoplus.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication   //starting point, contains several other annotations
@ComponentScan("com.thinkxfactor") //finds all the beans in our package
@EnableJpaRepositories(basePackages = "com.thinkxfactor")
@EntityScan("com.thinkxfactor")  //looks for all the objects that have @entity above it
public class ZomatoplusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZomatoplusApplication.class);
	}
	
	
}
