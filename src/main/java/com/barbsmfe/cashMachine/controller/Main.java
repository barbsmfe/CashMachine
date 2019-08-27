package com.barbsmfe.cashMachine.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.barbsmfe.cashMachine.domain.CashMachine;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Scanner keyboard = applicationContext.getBean(Scanner.class);
		CashMachine cashMachine = applicationContext.getBean(CashMachine.class, applicationContext);
		
		System.out.println("Type the value you wish to take from this cash machine: ");
		int cashValue = keyboard.nextInt();
		
		System.out.println("-- NUMBER OF BANKNOTES --");
		System.out.println(cashMachine.getLeastNumberOfBanknotes(cashValue));
	}
}
