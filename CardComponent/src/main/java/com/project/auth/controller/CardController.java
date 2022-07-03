package com.project.auth.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.auth.model.Card;
import com.project.auth.service.CardService;


@RestController
@RequestMapping("cartoes")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Card cartao) {
		
	try {	
		
		Card card = service.findCard(cartao.getNumber());
		
		if(Objects.isNull(card)) {
				
			card = service.create(cartao);

		} else {
					 return new ResponseEntity<>(card, HttpStatus.UNPROCESSABLE_ENTITY);

		}
		
		 return new ResponseEntity<>(card, HttpStatus.CREATED);
		 
	}catch(Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		 
		 }
	}
	
	@PatchMapping
	public ResponseEntity<?> update(@RequestBody Card cartao) {
		
	try {	
		

				
			Card card = service.update(cartao);


		
		 return new ResponseEntity<>(card, HttpStatus.CREATED);
		 
	}catch(Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		 
		 }
	}
	
	@GetMapping("/{cardNumber}")
	public ResponseEntity<?> getCardAmount(@PathVariable String cardNumber) {
		
	try {	
		Double saldo = service.verifyAmount(cardNumber);
		
		 return new ResponseEntity<>(saldo, HttpStatus.OK);
		 
	}catch(Exception e) {
		 return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);	
		 }
	}
	
		@RequestMapping(value = "/card/{cardNumber}", 
				consumes="*/*",
                produces = MediaType.APPLICATION_JSON_VALUE,
                method = RequestMethod.GET)
	public ResponseEntity<?> getCard(@PathVariable String cardNumber) {
		
	try {	
		Card card = service.findCard(cardNumber);
		 return new ResponseEntity<>(card, HttpStatus.OK);
		 
	}catch(Exception e) {
		 return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);	
		 }
	}

}
