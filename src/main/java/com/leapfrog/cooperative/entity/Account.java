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
public class Account {
    private int id;
    private String account_no;
    private String account_type;
    private String identification_id_no;
    private boolean status;
    private Date date;
    private TotalBalance Total;

    public Account() {
    }

    public Account(int id, String account_no, String account_type, String identification_id_no, boolean status, Date date, TotalBalance Total) {
        this.id = id;
        this.account_no = account_no;
        this.account_type = account_type;
        this.identification_id_no = identification_id_no;
        this.status = status;
        this.date = date;
        this.Total = Total;
    }

    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getIdentification_id_no() {
        return identification_id_no;
    }

    public void setIdentification_id_no(String identification_id_no) {
        this.identification_id_no = identification_id_no;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TotalBalance getTotal() {
        return Total;
    }

    public void setTotal(TotalBalance Total) {
        this.Total = Total;
    }
    
    
    
    
    
    
    
}
