package com.project.auth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.auth.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
