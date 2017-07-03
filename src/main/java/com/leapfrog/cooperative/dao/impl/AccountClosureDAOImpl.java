/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao.impl;

import com.leapfrog.cooperative.dao.AccountClosureDAO;
import com.leapfrog.cooperative.entity.AccountClosure;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Niru
 */
@Repository(value="accountClosureDAO")
public class AccountClosureDAOImpl implements AccountClosureDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insert(AccountClosure ac) throws SQLException, ClassNotFoundException {
        String sql="Insert into  accountclosure(account_id,customer_id,closure_reason,closure_date) values(?,?,?,?)";
       return jdbcTemplate.update(sql, new Object[]{ac.getAccount().getId(),ac.getCustomer().getId(),ac.getClosure_reason(),ac.getClosure_date()});
       
    }

    @Override
    public List<AccountClosure> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountClosure getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(AccountClosure t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
