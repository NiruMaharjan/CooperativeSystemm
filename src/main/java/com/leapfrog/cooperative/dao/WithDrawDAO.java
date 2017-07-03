/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao;

import com.leapfrog.cooperative.entity.WithDraw;
import java.util.List;

/**
 *
 * @author Niru
 */
public interface  WithDrawDAO extends GenericDAO<WithDraw> {
   List<WithDraw> getAllwithDrawnAmountOfaCustomer(int id);
    
    
}
