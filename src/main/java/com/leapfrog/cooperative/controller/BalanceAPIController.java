/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.controller;

import com.leapfrog.cooperative.dao.BalanceDAO;
import com.leapfrog.cooperative.dao.TotalBalanceDAO;
import com.leapfrog.cooperative.dao.WithDrawDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Balance;
import com.leapfrog.cooperative.entity.Customer;
import com.leapfrog.cooperative.entity.WithDraw;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Niru
 */
@RestController

public class BalanceAPIController {

    @Autowired
    private BalanceDAO balanceDAO;

    @Autowired
    private TotalBalanceDAO totalbalanceDAO;
    
    @Autowired
    private WithDrawDAO withDrawDAO;

//    @RequestMapping(value = "**/api/balance/amount", method = RequestMethod.GET)
//    public Balance index(@RequestParam("account_id") int account_id, @RequestParam("customer_id") int customer_id) {
//        return new Balance(1, new Customer(1, "Niru", "kirtipur", "nmaharjan417@gmail.com", "98292222", "Female", new Account(1, "928922", "current", "222", true)), 1200,);
//
//    }
   
    @RequestMapping(value = "**/api/balance/amountlist", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity indexx(@RequestParam("account_id") int account_id, @RequestParam("customer_id") int customer_id) {
        List<Balance> balance = new ArrayList<>();
        
        try {
            balance = balanceDAO.listOfBalanceDeposited(customer_id,account_id);
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity(balance, HttpStatus.OK);
        
    }
    
    
    @RequestMapping(value="**api/balance/withdrawlist",method=RequestMethod.GET,produces={"application/json"})
    public ResponseEntity withdrawindex(@RequestParam("account_id") int account_id,@RequestParam("customer_id") int customer_id){
        List<WithDraw> withdraw=new ArrayList<>();
        try{
       withdraw=withDrawDAO.getAllwithDrawnAmountOfaCustomer(account_id);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity(withdraw,HttpStatus.OK);
       
        
    }

    @RequestMapping(value = "**/api/balance/save", method = RequestMethod.GET)
    public String save(@RequestParam("customer_id") int customer_id, @RequestParam("account_id") int account_id, @RequestParam("amount") int amount) {
        
     int result;
        int update = 0;
        String name=null;
        Balance balance = new Balance();
        Customer customer = new Customer();
        customer.setId(customer_id);
        balance.setCustomer(customer);
        Account account = new Account();
        account.setId(account_id);
        balance.setAccount(account);
        balance.setAmount(amount);

        try {
           // result=balanceDAO.insert(balance);
            //System.out.println(result);
//            System.out.println("Heelo");
//           
//          result=totalbalanceDAO.check(account_id, customer_id);
//          System.out.println("result"+result);
//            
             update = totalbalanceDAO.updateTotalAmountonDeposit(account_id, amount);
               result = balanceDAO.insert(balance);
//            }
//            System.out.println("check:" + check);
//
//            System.out.println("update " + update);
//          
//            System.out.println("result " + result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/balance/Deposit";
    }

}
