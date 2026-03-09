package com.expensetracker.backend.service;

import com.expensetracker.backend.entity.Transaction;
import com.expensetracker.backend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAllByOrderByDateDesc();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction updateTransaction(Long id, Transaction updated) {
        Transaction existing = getTransactionById(id);
        existing.setDescription(updated.getDescription());
        existing.setAmount(updated.getAmount());
        existing.setType(updated.getType());
        existing.setCategory(updated.getCategory());
        existing.setDate(updated.getDate());
        return transactionRepository.save(existing);
    }

    @Transactional
    public void deleteTransaction(Long id) {
        Transaction existing = getTransactionById(id);
        transactionRepository.delete(existing);
    }

    public List<Transaction> getTransactionsForMonth(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        return transactionRepository.findByDateBetween(start, end);
    }
}
