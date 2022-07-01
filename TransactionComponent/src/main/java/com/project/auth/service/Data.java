package com.project.auth.service;

import com.project.auth.model.Card;

public abstract class Data {
	
	protected Card card;
	
	abstract Boolean verify(Object value);
	
	public Data(Card card) {
		this.card = card;
	}

}
