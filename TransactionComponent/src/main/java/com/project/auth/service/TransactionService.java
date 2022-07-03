
package com.project.auth.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.project.auth.model.Card;
import com.project.auth.repo.CardFeignClient;

import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TransactionService {
	

@Autowired
private CardFeignClient cardFeignClient;

	
	public Card authorize(Card card) throws Exception{
		Card actualCard = cardFeignClient.findByNumber(card.getNumber());
		
		if(Objects.isNull(actualCard)) {
			
			throw new Exception("CARTAO_INEXISTENTE");
		}
		
		Data pass = new PasswordData(actualCard);
		if(!pass.verify(card.getPassword())) {
			
			throw new Exception("SENHA_INVALIDA");
		}
		
		Data balance = new BalanceData(actualCard);
		if(!balance.verify(card.getAmount())) {
			
			throw new Exception("SALDO_INSUFICIENTE");
		}
		
		return actualCard;
	}


}
