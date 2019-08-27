package com.barbsmfe.cashMachine.controller;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.barbsmfe.cashMachine.domain.*;

@Configuration
@ComponentScan(basePackages = "com.barbsmfe.zenviaTest.cashMachine")
public class AppConfig {

		@Bean
	@Scope("prototype")
	public CashMachine cashMachine(@Value("${applicationContext}") final ApplicationContext applicationContext) {
		return new CashMachine(applicationContext);
	}
	
	@Bean
	@Scope("prototype")
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	@Scope("prototype")
	public HashMap<Integer,Integer> hashmap() {
		return new HashMap<Integer, Integer>();
	}
}