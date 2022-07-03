package com.project.auth.model;

public interface Order {
	
	Card authorize(Card card) throws Exception;

}
