package com.kintsugi.MiniKintusgi.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.kintsugi.MiniKintusgi.model.Transaction;
@Service
public class TransactionService {
/* Temporary in memory storage , and later this will be replaced with database
*/
    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction createTransaction(Transaction transaction){
        transactions.add(transaction);
        return transaction;

    }

    public List<Transaction> getAllTransactions(){
        return transactions;
    }

    public Transaction getTransactionById(Long id) {

        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }

return null;
    }





}
