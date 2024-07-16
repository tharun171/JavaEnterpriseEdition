package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableAutoConfiguration(exclude =
{
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
public class SbSendingDataMultiplePagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSendingDataMultiplePagesApplication.class, args);
	
		System.out.println("started application");
		System.out.println("comparing ModelMap,HttpServletRequest, HttpSession");
		System.out.println("which is able to send data to multiple pages");
	
	
	}

}
