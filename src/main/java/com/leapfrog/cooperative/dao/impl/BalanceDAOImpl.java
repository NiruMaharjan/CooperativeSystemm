/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao.impl;

import com.leapfrog.cooperative.dao.BalanceDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Balance;
import com.leapfrog.cooperative.entity.Customer;
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
@Repository(value = "balanceDAO")
public class BalanceDAOImpl implements BalanceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Balance b) throws SQLException, ClassNotFoundException {
        String sql = "Insert into balance(customer_id,account_id,amount)values(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{b.getCustomer().getId(), b.getAccount().getId(), b.getAmount()});
    }

    @Override
    public List<Balance> getAll() throws SQLException, ClassNotFoundException {
        String sql = "Select *From balance b join  customers c on c.customer_id=b.customer_id join account a on a.account_id=b.account_id ";
        return jdbcTemplate.query(sql, new BalanceMapper());

    }

    @Override
    public List<Balance> listOfBalanceDeposited(int customer_id, int account_id) {
        String sql = "Select b.*,a.*,c.* From balance b"
                + " join customers c on c.customer_id=b.customer_id "
                + "join account a on a.account_id=b.account_id "
                + "where b.customer_id=? and b.account_id=?";
        return jdbcTemplate.query(sql, new Object[]{customer_id, account_id}, new BalanceMapper1());
    }

    @Override
    public Balance getFirstRecord(int account_id) {
        String sql="Select *From balance where account_id=? order by deposited_date asc limit 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{account_id}, new RecordMapper() );
    }
    
   

    @Override
    public Balance getLastRecord(int account_id) {
         String sql="Select *From balance where account_id=? order by deposited_date desc limit 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{account_id}, new RecordMapper() );
    }
    
     private class RecordMapper implements RowMapper<Balance>{

        @Override
        public Balance mapRow(ResultSet rs, int i) throws SQLException {
            Balance b=new Balance();
            b.setId(rs.getInt("balance_id"));
            Account account=new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer=new Customer();
            customer.setId(rs.getInt("customer_id"));
            b.setAccount(account);
            b.setCustomer(customer);
            b.setAmount(rs.getInt("amount"));
            b.setAdded_Date(rs.getDate("deposited_date"));
            return b;
            
        }
        
    }

//    @Override
//    public List<Balance> getTotalSumOfAmountsAccordingToAccountIdAndCustomerId() {
//        String sql = "SELECT a.*,b.*,c.*,sum(amount) as total from balance b"
//                + " join customers c on c.customer_id=b.customer_id "
//                + "join account a on a.account_id=b.account_id "
//                + "group by b.account_id";
//        return jdbcTemplate.query(sql, new BalanceMapper());
//    }

    private class BalanceMapper implements RowMapper<Balance> {

        @Override
        public Balance mapRow(ResultSet rs, int i) throws SQLException {
            Balance b = new Balance();
            b.setId(rs.getInt("balance_id"));
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
            b.setAdded_Date(rs.getDate("deposited_date"));
            b.setAmount(rs.getInt("total"));
            return b;
        }

    }

    private class BalanceMapper1 implements RowMapper<Balance> {

        @Override
        public Balance mapRow(ResultSet rs, int i) throws SQLException {
            Balance b = new Balance();
            b.setId(rs.getInt("balance_id"));
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
            b.setAdded_Date(rs.getDate("deposited_date"));
            b.setAmount(rs.getInt("amount"));

            return b;
        }

    }

    @Override
    public Balance getById(int id) throws SQLException, ClassNotFoundException {
        String sql = "Select *From balance where balance_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BalanceMapper());

    }

    @Override
    public int update(Balance t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
