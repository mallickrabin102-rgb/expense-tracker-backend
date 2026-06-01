package com.rabin.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "expense_records")
public class Expense {
    @Id
    private int id;
    private String title;
    private double amount;
    private String category;
    private String expenseDate;
    private int userId;

    public Expense(int id,String title,double amount,String category,String expenseDate,int userId){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.expenseDate = expenseDate;
        this.userId = userId;
    }
    public Expense(){

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
       return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getExpenseDate(){
return expenseDate;
    }
    public void setExpenseDate(String expenseDate){
        this.expenseDate = expenseDate;
    }

     public int getUserid(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }

}
