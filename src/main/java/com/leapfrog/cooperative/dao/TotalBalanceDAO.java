/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao;

import com.leapfrog.cooperative.entity.TotalBalance;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Niru
 */
public interface TotalBalanceDAO extends GenericDAO<TotalBalance>{
  boolean check(int account_id,int customer_id) throws SQLException,ClassNotFoundException;
    int updateTotalAmountonDeposit(int account_id,int depositedamount) throws SQLException,ClassNotFoundException;
    String print();
    int updateTotalAmountonWithDraw(int account_id,int withDrawnAmount)throws SQLException,ClassNotFoundException;
}
