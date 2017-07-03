/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.controller;

import com.leapfrog.cooperative.dao.AccountDAO;
import com.leapfrog.cooperative.dao.CustomerDAO;
import com.leapfrog.cooperative.entity.Account;
import com.leapfrog.cooperative.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Niru
 */
@Controller
@RequestMapping(value = "/account/*")
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "admin/account/openaccount";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("account_number") String account_no, @RequestParam("account_type") String account_type, @RequestParam("id_no") String identification_id_no, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("email") String email, @RequestParam("gender") String gender, @RequestParam("contact_no") String contact_no, @RequestParam("status") boolean status) {
        //return account_no+" "+account_type+" "+identification_id_no+" "+name+" "+address+" "+email+" "+gender+" "+contact_no+" "+status+"";  
        // int account_insert_message=0;
        //int customer_record=0;
        Account account = new Account();
        account.setAccount_no(account_no);
        account.setAccount_type(account_type);
        account.setIdentification_id_no(identification_id_no);
        account.setStatus(status);
        try {
            accountDAO.insert(account);
            Customer customer = new Customer();
            customer.setName(name);
            customer.setAddress(address);
            customer.setContact_no(contact_no);
            customer.setEmail(email);
            customer.setGender(gender);
            Account a = accountDAO.getByAccountNo(account_no);
            account.setId(a.getId());
            customer.setAccount(account);

            customerDAO.insert(customer);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/index";
    }

    @RequestMapping(value = "/searchaccount", method = RequestMethod.GET)
    public String searchaccount(Model model) {
        try {
            model.addAttribute("customers", customerDAO.getAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "admin/account/searchaccount";

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        return name;

    }

    @RequestMapping(value = "/closeaccount", method = RequestMethod.GET)
    public String search(Model model) {
        try{
        model.addAttribute("customers", customerDAO.getAll());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return "admin/account/closeaccount";
        

    }

}
