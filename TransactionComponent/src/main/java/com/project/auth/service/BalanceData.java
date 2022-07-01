package com.project.auth.service;

import com.project.auth.model.Card;

public class BalanceData extends Data {

	public BalanceData(Card card) {
		super(card);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean verify(Object value) {
		// TODO Auto-generated method stub
		return card.getAmount() >= (double) value;
	}

}
