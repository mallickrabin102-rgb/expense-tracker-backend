package com.rabin.demo;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
public class ExpenseController {
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping(("/expenses/user/{userId}"))
    public List<Expense> getExpensesByUser(@PathVariable int userId) {
        return expenseRepository.findByUserId(userId);
    }

    @GetMapping("/expenses/title/{title}")
    public List<Expense> getExpensesByTitle(@PathVariable String title) {
        return expenseRepository.findByTitle(title);
    }

    @GetMapping("/expenses/category/{category}")
    public List<Expense> getExpensesByCategory(@PathVariable String category) {
        return expenseRepository.findByCategory(category);
    }

    @GetMapping("/expenses/amount/{amount}")
    public List<Expense> getExpensesByAmountGreaterThan(@PathVariable double amount) {
        return expenseRepository.findByAmountGreaterThan(amount);
    }

    @GetMapping("/expenses/user/{userId}/category/{category}")
    public List<Expense> getExpenseByUserIdAndCategory(@PathVariable int userId,
            @PathVariable String category) {
        return expenseRepository.findByUserIdAndCategory(userId, category);
    }

    @PostMapping("/expense")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable int id) {
        expenseRepository.deleteById(id);
        return "Expense Deleted Successfully";
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpense(
            @PathVariable int id,
            @RequestBody Expense expense

    ) {
   Optional<Expense> updateExpense = expenseRepository.findById(id);
       if (!updateExpense.isPresent()) {
    throw new RuntimeException("Expense Not Found");
}
    Expense oldExpense =  updateExpense.get();

    oldExpense.setAmount(expense.getAmount());
    oldExpense.setCategory(expense.getCategory());
    oldExpense.setTitle(expense.getTitle());
    oldExpense.setExpenseDate(expense.getExpenseDate());
    oldExpense.setUserId(expense.getUserid());
    expenseRepository.save(oldExpense);
    return oldExpense;
    }

}
