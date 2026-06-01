package com.rabin.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
List<Expense> findByUserId(int userId);
List<Expense> findByTitle(String title);
List<Expense> findByCategory(String category);
List<Expense> findByAmountGreaterThan(double amount);
List<Expense> findByUserIdAndCategory(int userId, String category);
    
}
