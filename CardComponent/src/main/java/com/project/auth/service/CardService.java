package com.project.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.auth.model.Card;
import com.project.auth.repo.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository repository;
	
	public void create(Card card) {
		
		repository.save(card);
	}
	
	public Card findCart(String number) {
		
		return repository.findCardByNumber(number);
		
	}

}
