package com.project.auth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.project.auth.model.Transaction;
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
