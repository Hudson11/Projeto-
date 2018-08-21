/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.dao;

import com.ufrn.testmaven.interfaces.iAutenticaDao;
import com.ufrn.testmaven.model.Autentica;



/**
 *
 * @author Hudson
 */
public class AutenticaDaoImpl extends GenericDaoImpl<Autentica, Integer> implements iAutenticaDao{

    public AutenticaDaoImpl() {
        super(Autentica.class);
    }

}
