package com.project.auth.service;

import com.project.auth.model.Card;

public class PasswordData extends Data {

	public PasswordData(Card card) {
		super(card);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean verify(Object value) {
		// TODO Auto-generated method stub
		return card.getPassword().equals((String) value);
	}

}
