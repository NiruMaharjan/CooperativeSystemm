/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.entity;

/**
 *
 * @author Niru
 */
public class TotalBalance {
    private int id;
   
    private Customer customer;
    private int amount;
    private Account account;

    public TotalBalance() {
    }

    public TotalBalance(int id, Customer customer, int amount, Account account) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
}
