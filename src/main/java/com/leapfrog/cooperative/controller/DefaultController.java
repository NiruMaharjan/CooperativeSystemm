/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.controller;

import com.leapfrog.cooperative.dao.BalanceDAO;
import com.leapfrog.cooperative.dao.CustomerDAO;
import com.leapfrog.cooperative.dao.TotalBalanceDAO;
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
@RequestMapping(value = "/admin/**")
public class DefaultController {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private TotalBalanceDAO  totalBalanceDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model ) {
        try {
            
            model.addAttribute("customers",customerDAO.getAll());
            model.addAttribute("balance", totalBalanceDAO.getAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/index";
    }
    
    
   
   @RequestMapping(value="/pageRequest/{page}",method = RequestMethod.GET)
    public String limitedCustomers(Model model ,@PathVariable int pageid) {
        try {
            
           model.addAttribute("customers",customerDAO.getLimitedCustomers(pageid));
            model.addAttribute("balance", totalBalanceDAO.getAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/index";
    }

}
