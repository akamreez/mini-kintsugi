package com.kintsugi.MiniKintusgi.controller;

import com.kintsugi.MiniKintusgi.model.Transaction;
import com.kintsugi.MiniKintusgi.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.kintsugi.MiniKintusgi.dto.TransactionRequestDTO;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    } // this is DI

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction( dto));

    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable long id){
        return transactionService.getTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTransaction(@PathVariable Long id){
        return transactionService.deleteTransaction(id);
    }
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id ,
                                         @Valid @RequestBody Transaction updatedTransaction){

        return transactionService.updateTransaction(id,updatedTransaction);
    }

}

