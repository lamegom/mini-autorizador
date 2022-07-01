package com.project.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.project.auth.model.Card;
import com.project.auth.service.CardService;

@RestController
@RequestMapping("card")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@PostMapping
	public ResponseEntity<?> create(Card card) {
		
	try {	
		service.create(card);
		
		 return new ResponseEntity<>(null, HttpStatus.CREATED);
		 
	}catch(Exception e) {
		 return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		 }
	}

}
