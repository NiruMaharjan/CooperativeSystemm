/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao.impl;

import com.leapfrog.cooperative.dao.TotalBalanceDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Balance;
import com.leapfrog.cooperative.entity.Customer;
import com.leapfrog.cooperative.entity.TotalBalance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Niru
 */
@Repository(value = "totalBalanceDAO")
public class TotalBalanceDAOImpl implements TotalBalanceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(TotalBalance t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TotalBalance> getAll() throws SQLException, ClassNotFoundException {
        String sql = "Select *From totalbalance b join customers c  on c.customer_id=b.customer_id join account a on a.account_id=b.account_id";
        return jdbcTemplate.query(sql, new TotalBalanceMapper());
    }

    @Override
    public boolean check(int account_id,int customer_id) throws SQLException, ClassNotFoundException {
        for (TotalBalance b : getAll()) {
            if ((b.getAccount().getId()==account_id) && (b.getCustomer().getId()==customer_id)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public int updateTotalAmountonDeposit(int account_id, int depositedamount) throws SQLException, ClassNotFoundException {
        String sql = "Update totalbalance set amount=amount +" + depositedamount + " where account_id=?";
        return jdbcTemplate.update(sql, new Object[]{account_id});
    }

    @Override
    public String print() {
        return "heelo niru";
    }

    @Override
    public int updateTotalAmountonWithDraw(int account_id, int withDrawnAmount) throws SQLException, ClassNotFoundException {
        String sql="Update totalbalance set amount=amount -"+ withDrawnAmount +" where account_id=?";
        return jdbcTemplate.update(sql,new Object[]{account_id});
    }

    private class TotalBalanceMapper implements RowMapper<TotalBalance> {

        @Override
        public TotalBalance mapRow(ResultSet rs, int i) throws SQLException {
            TotalBalance b = new TotalBalance();
            b.setId(rs.getInt("id"));
            Customer customer = new Customer();
            customer.setId(rs.getInt("customer_id"));
            customer.setName(rs.getString("customer_name"));
            customer.setAddress(rs.getString("address"));
            customer.setEmail(rs.getString("email"));
            customer.setGender(rs.getString("gender"));
            customer.setContact_no(rs.getString("contact_no"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            account.setAccount_no(rs.getString("account_no"));
            account.setAccount_type(rs.getString("account_type"));
            account.setIdentification_id_no(rs.getString("identification_id_no"));
            account.setStatus(rs.getBoolean("status"));
            customer.setAccount(account);
            b.setCustomer(customer);

            b.setAmount(rs.getInt("amount"));
            return b;
        }
    }

    @Override
    public TotalBalance getById(int id) throws SQLException, ClassNotFoundException {
        String sql="Select *From totalbalance t join customers c on c.customer_id=t.customer_id join account a on a.account_id=t.account_id where  t.customer_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TotalBalanceMapper());
    }

    @Override
    public int update(TotalBalance t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
