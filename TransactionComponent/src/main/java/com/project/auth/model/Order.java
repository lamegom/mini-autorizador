package com.project.auth.model;

public interface Order {
	
	void authorize(Card card) throws Exception;

}
