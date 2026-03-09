package com.expensetracker.backend.repository;

import com.expensetracker.backend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByOrderByDateDesc();

    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);
}
