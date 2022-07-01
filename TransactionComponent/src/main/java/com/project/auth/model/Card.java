package com.project.auth.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Card {

	@Id
	@GeneratedValue 
	private Long id;
	private String number;
	private Double amount;
	private String password;
	@Override
	public int hashCode() {
		return Objects.hash(amount, number, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return amount >= other.amount && Objects.equals(number, other.number)
				&& Objects.equals(password, other.password);
	}
	
	
	
}
