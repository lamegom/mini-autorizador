package com.project.auth.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.TransactionalRepositoryFactoryBeanSupport;
import org.springframework.stereotype.Service;

import com.project.auth.model.Card;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Service
public class TransactionService {
	

	
	public void authorize(Card card) throws Exception{
		Card actualCard = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(Card.class))
				  .logLevel(Logger.Level.FULL)
				  .target(Card.class, "http://localhost:8081/card/" + card.getNumber());
		
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
		
		
	}


}
