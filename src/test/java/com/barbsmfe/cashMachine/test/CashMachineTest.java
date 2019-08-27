package com.barbsmfe.cashMachine.test;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.barbsmfe.cashMachine.controller.AppConfig;
import com.barbsmfe.cashMachine.domain.CashMachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CashMachineTest {

	private ApplicationContext applicationContext;
	private CashMachine cashMachine;

	@Before
	public void setup() {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		cashMachine = applicationContext.getBean(CashMachine.class, applicationContext);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testIfNumberOfBanknotesForEightyIsTheLeastNumber() {
		Map<Integer, Integer> leastBanknoteMapTest = applicationContext.getBean(HashMap.class);
		leastBanknoteMapTest.put(100, 0);
		leastBanknoteMapTest.put(50, 1);
		leastBanknoteMapTest.put(20, 1);
		leastBanknoteMapTest.put(10, 1);
		assertEquals(leastBanknoteMapTest, cashMachine.getLeastNumberOfBanknotes(80));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testIfNumberOfBanknotesForThirtyIsTheLeastNumber() {
		Map<Integer, Integer> leastBanknoteMapTest = applicationContext.getBean(HashMap.class);
		leastBanknoteMapTest.put(100, 0);
		leastBanknoteMapTest.put(50, 0);
		leastBanknoteMapTest.put(20, 1);
		leastBanknoteMapTest.put(10, 1);
		assertEquals(leastBanknoteMapTest, cashMachine.getLeastNumberOfBanknotes(30));
	}

	@Test
	public void testIfDesiredValueCannotBeTakenFromTheCashMachine() {
		assertThrows(IllegalArgumentException.class, () -> {
			cashMachine.getLeastNumberOfBanknotes(155);
		});
	}

	@Test
	public void testIfDesiredValueIsNegativeAndCannotBeTakenFromTheCashMachine() {
		assertThrows(IllegalArgumentException.class, () -> {
			cashMachine.getLeastNumberOfBanknotes(-10);
		});
	}

	@Test
	public void testIfDesiredValueIsZeroAndCannotBeTakenFromTheCashMachine() {
		assertThrows(IllegalArgumentException.class, () -> {
			cashMachine.getLeastNumberOfBanknotes(0);
		});
	}
}
