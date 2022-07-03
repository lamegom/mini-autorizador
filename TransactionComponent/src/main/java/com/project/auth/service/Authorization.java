package com.project.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.auth.model.Card;
import com.project.auth.model.Order;
import com.project.auth.model.Transaction;
import com.project.auth.repo.CardFeignClient;
import com.project.auth.repo.TransactionRepository;

@Component
public class Authorization {
	
    private Transaction transaction;
    private List<Order> orders = new ArrayList<>();
    
	@Autowired
	private TransactionRepository repo;
	@Autowired
	private CardFeignClient feign;

    public void addObserver(Order order) {
        this.orders.add(order);
    }

    public void removeObserver(Order order) {
        this.orders.remove(order);
    }

    public void setStatus(Transaction transaction) throws Exception {
        this.transaction = transaction;
        for (Order o : this.orders) {
        	
        	String status = "OK";
        	try {
        		
        		Card card = this.transaction.getCard();
        		Card actualCard = o.authorize(card);
								System.out.println("card.getAmount()" + card.getAmount());

				System.out.println("actualCard.getAmount()" + actualCard.getAmount());
				
				actualCard.setAmount(actualCard.getAmount() - card.getAmount());
        		
        		feign.updateAmount(actualCard);
        	}catch(Exception e) {
        		status = e.getLocalizedMessage();
        		
        		throw e;
        		
        	} finally {
        		
        		this.transaction.setStatus(status);
        		repo.save(this.transaction);
        	}
        	
        	
        }
    }

}
