package com.project.auth.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.databind.annotation.*;

import com.fasterxml.jackson.annotation.*;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {


	@Id
	@GeneratedValue 
	private Long id;
	@JsonProperty("numeroCartao")
	private String number;
	@JsonProperty("valor")
	private Double amount;
	@JsonProperty("senhaCartao")
	private String password;
	
	@JsonProperty("senha")
    public String getSenha() {
      return password;
    }

    public void setSenha(String password) {
      this.password = password;
    }
	
	
	
}
