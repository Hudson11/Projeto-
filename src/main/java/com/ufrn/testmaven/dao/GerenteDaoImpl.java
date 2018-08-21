/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.dao;

import com.ufrn.testmaven.interfaces.iGerenteDao;
import com.ufrn.testmaven.model.Gerente;

/**
 *
 * @author Hudson
 */
public class GerenteDaoImpl extends GenericDaoImpl <Gerente, Integer> implements iGerenteDao{

    public GerenteDaoImpl() {
        super(Gerente.class);
    }
    
}
