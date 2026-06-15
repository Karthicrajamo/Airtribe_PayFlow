package com.assessement.upi_payment.controller;

import com.assessement.upi_payment.entity.Transaction;
import com.assessement.upi_payment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    public TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.sendMoney(transaction);
    }

    @GetMapping
    public List<Transaction>  getAllTransactions(){
        return transactionService.getAllTransaction();
    }

}
