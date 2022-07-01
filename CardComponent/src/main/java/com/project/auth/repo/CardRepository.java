package com.project.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.auth.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	Card findCardByNumber(String number);
}
