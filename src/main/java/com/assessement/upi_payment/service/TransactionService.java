package com.assessement.upi_payment.service;

import com.assessement.upi_payment.entity.Transaction;
import com.assessement.upi_payment.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction sendMoney(Transaction transaction){
        LocalDateTime currentDateTime = LocalDateTime.now();
        transaction.setTransactionTime(currentDateTime);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }
}
