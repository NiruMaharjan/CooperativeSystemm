/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao.impl;

import com.leapfrog.cooperative.dao.AccountDAO;
import com.leapfrog.cooperative.entity.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Niru
 */
@Repository(value="accountDAO")
public class AccountDAOImpl implements AccountDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Account a) throws SQLException, ClassNotFoundException {
        String sql="Insert into account(account_no,account_type,identification_id_no,status) values(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{a.getAccount_no(),a.getAccount_type(),a.getIdentification_id_no(),a.isStatus()});
    }

    @Override
    public List<Account> getAll() throws SQLException, ClassNotFoundException {
        String sql="Select *From account";
        return jdbcTemplate.query(sql, new AccountMapper());
    }

      

    @Override
    public Account getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Account t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getByAccountNo(String account_no) {
        String sql="Select *from account where account_no=?";
       return jdbcTemplate.queryForObject(sql,new Object[]{account_no},new AccountMapper());
    }
    
    private class AccountMapper implements RowMapper<Account>{

        @Override
        public Account mapRow(ResultSet rs, int i) throws SQLException {
            Account account=new Account();
            account.setId(rs.getInt("account_id"));
            account.setAccount_no(rs.getString("account_no"));
            account.setAccount_type(rs.getString("account_type"));
            account.setIdentification_id_no(rs.getString("identification_id_no"));
            account.setStatus(rs.getBoolean("status"));
            return account;
        }
        
    }
    
}
