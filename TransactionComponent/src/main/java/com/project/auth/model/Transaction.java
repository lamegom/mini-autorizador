package com.project.auth.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.auth.service.TransactionService;

import lombok.Data;

@Data
@Component
public class Transaction implements Order {
	
	private Card card;
	private String status;
	
	@Autowired
	private TransactionService service;
	
	@Override
	public Card authorize(Card card) throws Exception{
		// TODO Auto-generated method stub
		return service.authorize(card);
		
	}

}
