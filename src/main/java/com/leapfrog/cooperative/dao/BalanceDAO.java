/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao;

import com.leapfrog.cooperative.entity.Balance;
import java.util.List;

/**
 *
 * @author Niru
 */
public interface BalanceDAO extends GenericDAO<Balance> {
    List<Balance> listOfBalanceDeposited(int customer_id,int account_id);
    Balance getFirstRecord(int account_id);
    Balance getLastRecord(int account_id);
    //List<Balance> getTotalSumOfAmountsAccordingToAccountIdAndCustomerId();
    
}
