/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cooperative.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Niru
 */
public interface GenericDAO<T> {
    int insert(T t) throws SQLException,ClassNotFoundException;
    List<T> getAll()throws SQLException,ClassNotFoundException;
    T getById(int id)throws SQLException,ClassNotFoundException;
    int update(T t)throws SQLException,ClassNotFoundException;
    int delete(int id)throws SQLException,ClassNotFoundException;
    
}
