/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao.impl;

import com.leapfrog.cooperative.dao.WithDrawDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Customer;
import com.leapfrog.cooperative.entity.WithDraw;
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
@Repository(value = "repositoryDAO")
public class WithDrawDAOImpl implements WithDrawDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(WithDraw w) throws SQLException, ClassNotFoundException {
        String sql = "Insert into withdrawnbalancerecord(account_id,customer_id,withdrawn_date,amount_withdrawn) values(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{w.getAccount().getId(), w.getCustomer().getId(), w.getWithdrawn_date(), w.getAmount()});
    }

    @Override
    public WithDraw getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(WithDraw t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WithDraw> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WithDraw> getAllwithDrawnAmountOfaCustomer(int id) {
        String sql = "Select *From withdrawnbalancerecord where customer_id=?";
        return jdbcTemplate.query(sql, new Object[]{id}, new WithDrawMapper());

    }

    private class WithDrawMapper implements RowMapper<WithDraw> {

        @Override
        public WithDraw mapRow(ResultSet rs, int i) throws SQLException {
            WithDraw withDraw = new WithDraw();
            withDraw.setId(rs.getInt("id"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            withDraw.setAccount(account);
            Customer customer = new Customer();
            customer.setId(rs.getInt("customer_id"));
            withDraw.setCustomer(customer);
            withDraw.setWithdrawn_date(rs.getDate("withdrawn_date"));
            withDraw.setAmount(rs.getInt("amount_withdrawn"));
            return withDraw;

        }

    }
}
