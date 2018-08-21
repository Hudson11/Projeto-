/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.dao;

import com.ufrn.testmaven.interfaces.iClienteDao;
import com.ufrn.testmaven.model.Cliente;


/**
 *
 * @author Hudson
 */
public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements iClienteDao{
    
    public ClienteDaoImpl(){
        super(Cliente.class);
    }
}
