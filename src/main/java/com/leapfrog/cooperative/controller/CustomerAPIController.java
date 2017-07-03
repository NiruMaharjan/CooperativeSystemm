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
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Niru
 */
@RestController

public class CustomerAPIController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CustomerDAO customerDAO;

//    @RequestMapping(value = "**/api/customer",method=RequestMethod.GET)
//    public Customer index(@RequestParam("cid") int id) {
//        return new Customer(1, "Niru", "kirtipur", "nmaharjan417@gmail.com", "98292222", "Female", new Account(1, "928922", "current", "222", true));

//        Customer customer = null;
//        try {
//            customer = customerDAO.getById(id);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return new ResponseEntity(customer,HttpStatus.OK);
   // }

    @RequestMapping(value = "**/api/list" ,method=RequestMethod.GET,produces={"application/json"})
    public ResponseEntity detail(@RequestParam("cid") int id) {
        Customer customer = null;
        try {
            customer = customerDAO.getById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity(customer,HttpStatus.OK);

    }
//    
////    @RequestMapping(value="/api/customerlist",method=RequestMethod.GET)
////    public ResponseEntity detailss() {
////        List<Customer> customerList = new ArrayList<>();
////        try {
////            customerList = customerDAO.getAll();
////        } catch (Exception ex) {
////            System.out.println(ex.getMessage());
////        }
//         //HttpHeaders responseHeaders = new HttpHeaders();
//        return  new ResponseEntity(customerList,HttpStatus.OK);
//
//    }
    
//     @RequestMapping(value = "**/api/list",method=RequestMethod.GET,produces={"application/json"})
//    public Customer details(@RequestParam("cid") int id) {
//        Customer customer = null;
//        try {
//            customer = customerDAO.getById(id);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return  customer;
//    }
//    
    

}
