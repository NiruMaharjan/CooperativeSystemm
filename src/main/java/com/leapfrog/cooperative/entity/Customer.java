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
public class Customer {
    private int id;
    private String name,address,email,contact_no,gender;
    private Account account;

    public Customer() {
    }

    public Customer(int id, String name, String address, String email, String contact_no, String gender,Account account) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact_no = contact_no;
        this.gender = gender;
        this.account=account;
      
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
}
