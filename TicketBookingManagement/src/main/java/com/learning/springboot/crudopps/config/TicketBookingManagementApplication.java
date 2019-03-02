package com.learning.springboot.crudopps.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learning.springboot.crudopps.dao.TicketBookingDao;

@SpringBootApplication(scanBasePackages = "com.learning.springboot.crudopps")
@EnableJpaRepositories(basePackageClasses = TicketBookingDao.class)
@EntityScan(basePackages = "com.learning.springboot.crudopps")
public class TicketBookingManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementApplication.class, args);
	}
}
