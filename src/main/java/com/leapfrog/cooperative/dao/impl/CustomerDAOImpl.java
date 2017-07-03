/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao.impl;

import com.leapfrog.cooperative.dao.CustomerDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Customer;
import com.leapfrog.cooperative.entity.TotalBalance;
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
@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Customer c) throws SQLException, ClassNotFoundException {
        String sql = "Insert into customers(customer_name,address,email,contact_no,gender,account_id) values(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{c.getName(), c.getAddress(), c.getEmail(), c.getContact_no(), c.getGender(), c.getAccount().getId()});
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        String sql = "Select *From customers c join account a on c.account_id=a.account_id ";
        return jdbcTemplate.query(sql, new CustomerMapper());

    }

    @Override
    public Customer getById(int id) throws SQLException, ClassNotFoundException {
        String sql = "Select *From customers  c join account a on c.account_id=a.account_id   where c.customer_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerMapper());
    }

    @Override
    public List<Customer> getLimitedCustomers(int id) {
        int firstLimit = (5 * id) - 5;
        int lastLimit = 5;
        String sql = "Select *From customers c join account a on c.account_id=a.account_id" + " limit " + firstLimit + "," + lastLimit + "";
        return jdbcTemplate.query(sql, new CustomerMapper());
    }

    private class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int i) throws SQLException {

            Customer customer = new Customer();
            customer.setId(rs.getInt("customer_id"));
            customer.setName(rs.getString("customer_name"));
            customer.setAddress(rs.getString("address"));
            customer.setEmail(rs.getString("email"));
            customer.setGender(rs.getString("gender"));
            customer.setContact_no(rs.getString("contact_no"));
//            TotalBalance t = new TotalBalance(); This is a blunder mistake done  by me.TotalBalance entity ma account ra customer class cha.
//            t.setId(rs.getInt("id"));
//            t.setAmount(rs.getInt("amount"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            account.setAccount_no(rs.getString("account_no"));
            account.setAccount_type(rs.getString("account_type"));
            account.setIdentification_id_no(rs.getString("identification_id_no"));
            account.setDate(rs.getDate("added_date"));
            account.setStatus(rs.getBoolean("status"));
           // account.setTotal(t);
            customer.setAccount(account);
            return customer;

        }

    }

    @Override
    public int update(Customer t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
