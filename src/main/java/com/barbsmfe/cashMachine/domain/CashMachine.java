package com.barbsmfe.cashMachine.domain;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;

public class CashMachine {

	private static final int ONE_HUNDRED_BANKNOTE = 100;
	private static final int FIFTY_BANKNOTE = 50;
	private static final int TWENTY_BANKNOTE = 20;
	private static final int TEN_BANKNOTE = 10;

	private ApplicationContext applicationContext;

	public CashMachine(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public Map<Integer, Integer> getLeastNumberOfBanknotes(int cashValue)
			throws IllegalArgumentException {
		if (cashValue % 10 != 0) {
			throw new IllegalArgumentException();
		} else if (cashValue == 0) {
			throw new IllegalArgumentException();
		} else {
			return getLeastNumberOfBanknotes(cashValue, createAndOrganizeMapOfBanknotes());
		}
	}

	private Map<Integer, Integer> getLeastNumberOfBanknotes(int cashValue, Map<Integer, Integer> numberOfUsedBanknotes)
			throws IllegalArgumentException {
		if (cashValue == 0)
			return numberOfUsedBanknotes;

		int banknote = findBanknoteValue(cashValue);
		numberOfUsedBanknotes.put(banknote, numberOfUsedBanknotes.get(banknote) + 1);

		getLeastNumberOfBanknotes(cashValue - banknote, numberOfUsedBanknotes);

		return numberOfUsedBanknotes;
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, Integer> createAndOrganizeMapOfBanknotes() {		
		Map<Integer, Integer> organizedMapOfBanknotes = applicationContext.getBean(HashMap.class);

		organizedMapOfBanknotes.put(ONE_HUNDRED_BANKNOTE, 0);
		organizedMapOfBanknotes.put(FIFTY_BANKNOTE, 0);
		organizedMapOfBanknotes.put(TWENTY_BANKNOTE, 0);
		organizedMapOfBanknotes.put(TEN_BANKNOTE, 0);

		return organizedMapOfBanknotes;
	}

	private int findBanknoteValue(int valueClientChose) {
		if (valueClientChose >= 100) {
			return ONE_HUNDRED_BANKNOTE;
		} else if (valueClientChose >= 50) {
			return FIFTY_BANKNOTE;
		} else if (valueClientChose >= 20) {
			return TWENTY_BANKNOTE;
		} else if (valueClientChose >= 10) {
			return TEN_BANKNOTE;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
