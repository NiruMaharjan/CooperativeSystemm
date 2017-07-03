/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.controller;

import com.leapfrog.cooperative.dao.TotalBalanceDAO;
import com.leapfrog.cooperative.entity.TotalBalance;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TotalBalanceAPIController {
    
    @Autowired
    private TotalBalanceDAO totalBalanceDAO;
    
    @RequestMapping(value="**/api/detaillist", method=RequestMethod.GET, produces={"application/json"})
    public ResponseEntity detail(@RequestParam("cid") int id){
        TotalBalance tb=null;
        try{
        tb=totalBalanceDAO.getById(id);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity(tb,HttpStatus.OK);
    }
    
}
