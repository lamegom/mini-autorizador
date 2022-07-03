package com.project.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.auth.model.Card;
import com.project.auth.model.Transaction;
import com.project.auth.service.Authorization;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("transacoes")
public class AuthorizationController {
	
	@Autowired
	private Authorization observable;

	@Autowired
	private Transaction observer;
	
	@PostMapping
	public ResponseEntity<?> authorize(@RequestBody Card card) {
		
	try {	
		
		observer.setCard(card);

		observable.addObserver(observer);
		observable.setStatus(observer);
		observer.getStatus();
		observable.removeObserver(observer);

		
		return new ResponseEntity<>("OK", HttpStatus.CREATED);
		 
	}catch(Exception e) {
		e.printStackTrace();
		 return new ResponseEntity<>(e.getCause() + ": " + e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		 }
	}

}
