package com.project.auth.repo;

import java.util.List;

import com.project.auth.model.Card;

import feign.Param;
import feign.RequestLine;

public interface CardFeignClient {
	
	    @RequestLine("GET /{number}")
	    Card findByNumber(@Param("number") String number);

	    @RequestLine("GET")
	    List<Card> findAll();

	}