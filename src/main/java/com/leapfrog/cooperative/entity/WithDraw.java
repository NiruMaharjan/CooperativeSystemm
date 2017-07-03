/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.entity;

import java.sql.Date;

/**
 *
 * @author Niru
 */
public class WithDraw {
    private int id;
    private Account account;
    private Customer customer;
    private Date withdrawn_date;
    private int amount;

    public WithDraw() {
    }

    public WithDraw(int id, Account account, Customer customer, Date withdrawn_date, int amount) {
        this.id = id;
        this.account = account;
        this.customer = customer;
        this.withdrawn_date = withdrawn_date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getWithdrawn_date() {
        return withdrawn_date;
    }

    public void setWithdrawn_date(Date withdrawn_date) {
        this.withdrawn_date = withdrawn_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
   
    
}
