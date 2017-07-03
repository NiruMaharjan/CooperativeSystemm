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
public class AccountClosure {
    private int id;
    private Account account;
    private Customer customer;
    private String closure_reason;
    private String closure_date;

    public AccountClosure() {
    }

    public AccountClosure(int id, Account account, Customer customer, String closure_reason, String closure_date) {
        this.id = id;
        this.account = account;
        this.customer = customer;
        this.closure_reason = closure_reason;
        this.closure_date = closure_date;
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

    public String getClosure_reason() {
        return closure_reason;
    }

    public void setClosure_reason(String closure_reason) {
        this.closure_reason = closure_reason;
    }

    public String getClosure_date() {
        return closure_date;
    }

    public void setClosure_date(String closure_date) {
        this.closure_date = closure_date;
    }
    
    
    
}
