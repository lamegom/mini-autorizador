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

@RestController
@RequestMapping("auth")
public class AuthorizationController {
	
	@Autowired
	private Authorization auth;
	
	@PostMapping
	public ResponseEntity<?> authorize(Card card) {
		
	try {	
		Authorization observable = new Authorization();
		Transaction observer = new Transaction();
		observer.setCard(card);

		observable.addObserver(observer);
		observable.setStatus(observer);
		observer.getStatus();
		
		return new ResponseEntity<>(null, HttpStatus.CREATED);
		 
	}catch(Exception e) {
		 return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		 }
	}

}
