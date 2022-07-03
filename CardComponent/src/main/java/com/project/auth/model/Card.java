package com.project.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Entity
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
	@Column(unique=true)
	private String number;
	@JsonProperty("valor")
	private Double amount;
	@JsonProperty("senha")
	private String password;
}
