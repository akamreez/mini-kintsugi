package com.kintsugi.MiniKintusgi.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.kintsugi.MiniKintusgi.model.Transaction;
import com.kintsugi.MiniKintusgi.dto.TransactionRequestDTO;


@Service
public class TransactionService {
/* Temporary in memory storage , and later this will be replaced with database
*/
    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction createTransaction(TransactionRequestDTO dto){
        Transaction transaction = new Transaction();

        transaction.setCustomerName(dto.getCustomerName());
        transaction.setAmount(dto.getAmount());
        transaction.setState(dto.getState());
        transaction.setStatus(dto.getStatus());

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
        } return null;}

    public boolean deleteTransaction(Long id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                transactions.remove(transaction);
                return true;
            }

        }
        return false;}

    public Transaction updateTransaction(Long id , Transaction updatedTransaction){

        for(Transaction transaction: transactions){

            if(transaction.getId().equals(id)) {
                transaction.setCustomerName(updatedTransaction.getCustomerName());
                transaction.setAmount(updatedTransaction.getAmount());
                transaction.setState(updatedTransaction.getState());
                transaction.setStatus(updatedTransaction.getStatus());

                return transaction;
            }
        }
        return null;
    }
}
