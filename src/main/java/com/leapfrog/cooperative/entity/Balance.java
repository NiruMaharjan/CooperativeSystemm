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
public class Balance {
    private int id;
   
    private Customer customer;
    private Date added_Date;
    private int amount;
    private Account account;

    public Balance() {
    }

    public Balance(int id, Customer customer,  int amount) {
        this.id = id;
        this.customer = customer;
      
        this.amount = amount;
        
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

    public Date getAdded_Date() {
        return added_Date;
    }

    public void setAdded_Date(Date added_Date) {
        this.added_Date = added_Date;
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
