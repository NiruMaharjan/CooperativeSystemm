/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.controller;

import com.leapfrog.cooperative.dao.AccountClosureDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.AccountClosure;
import com.leapfrog.cooperative.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Niru
 */
@RestController
public class AccountAPIController {
    
    @Autowired
    private AccountClosureDAO accountClosureDAO;
    
    @RequestMapping(value="**/api/closeaccount/save", method=RequestMethod.GET)
    public String save(@RequestParam("customer_id") int customer_id,@RequestParam("account_id") int account_id, @RequestParam("closure_reason") String closure_reason,@RequestParam("account_closure_date") String account_closure_date){
        int result=0;
        AccountClosure ac=new AccountClosure();
        Customer customer= new Customer();
        customer.setId(customer_id);
        ac.setCustomer(customer);
        Account account=new Account();
        account.setId(account_id);
        ac.setAccount(account);
        ac.setClosure_reason(closure_reason);
        ac.setClosure_date(account_closure_date);
        try{
            result=accountClosureDAO.insert(ac);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result+"";
        
    }
    
}
