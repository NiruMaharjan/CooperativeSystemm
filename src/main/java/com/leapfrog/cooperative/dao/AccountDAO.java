/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao;

import com.leapfrog.cooperative.entity.Account;

/**
 *
 * @author Niru
 */
public  interface AccountDAO extends GenericDAO<Account> {
    public Account getByAccountNo(String account_no);
}
