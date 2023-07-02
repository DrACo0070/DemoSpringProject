package com.bway.springDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeInfoMgntSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInfoMgntSysApplication.class, args);
	}

}

/* Spring Starter Project main needs-
 * spring web
 * thymeleaf
 * spring boot dev tools
 * spring data JPA
 * mysql driver
 * lombok
 * 
 * Steps to implement any module(Student, User, Employee...etc)-
 * 1. POJO/Entity Class
 * write code in application.properties to connect db.
 * 2. Map to database(@Entity, @Table, @Id, @GeneratedValue=Identity)
 * 3. Repository
 * 4. Service
 * 5. ServiceImpl
 * 6. Controller
 * 7. View
 */