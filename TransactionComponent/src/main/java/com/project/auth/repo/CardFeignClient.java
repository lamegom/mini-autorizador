package com.project.auth.repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.auth.model.Card;


@FeignClient(name = "cardFeigClient", url = "http://localhost:8081", path = "cartoes")
public interface CardFeignClient {
	
		@GetMapping(value = {"/card/{number}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	    Card findByNumber(@PathVariable("number") String number);
		
		@PatchMapping
		Card updateAmount(@RequestBody Card card);
	}