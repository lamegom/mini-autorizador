package com.project.auth.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.auth.model.Card;
import com.project.auth.repo.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository repository;

	public Card findCard(String number) {
		
		return repository.findOneCardByNumber(number);
		
	}

	public Card create(Card cartao) throws Exception {
		
		Card card = Card.builder()
				.number(cartao.getNumber())
				.password(cartao.getPassword())
				.amount(500D)
				.build();
		
		repository.save(card);
		return card;
	}
	
		public Card update(Card card) throws Exception {
		
		repository.save(card);
		return card;
	}
	
	public Double verifyAmount (String numeroCartao) throws Exception {
		
	Card card = findCard(numeroCartao);
		
		if(Objects.isNull(card)) {
				
			throw new Exception ("cartao nao existe");	
		}
		
		return card.getAmount();
	}

}
