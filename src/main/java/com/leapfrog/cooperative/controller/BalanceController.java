/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.controller;

import com.leapfrog.cooperative.dao.AccountDAO;
import com.leapfrog.cooperative.dao.BalanceDAO;
import com.leapfrog.cooperative.dao.CustomerDAO;
import com.leapfrog.cooperative.dao.TotalBalanceDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Balance;
import com.leapfrog.cooperative.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Niru
 */
@Controller
@RequestMapping(value = "/balance/**")
public class BalanceController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private BalanceDAO balanceDAO;
    
    @Autowired
    private TotalBalanceDAO totalBalanceDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("customers", customerDAO.getAll());
            model.addAttribute("accounts", accountDAO.getAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "admin/balance/Deposit";
    }

    
    @RequestMapping(value="/withdraw",method=RequestMethod.GET)
    public String withdraw(Model model){
         try {
            model.addAttribute("customers", customerDAO.getAll());
            model.addAttribute("accounts", accountDAO.getAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "admin/balance/withdraw";
    }
}
