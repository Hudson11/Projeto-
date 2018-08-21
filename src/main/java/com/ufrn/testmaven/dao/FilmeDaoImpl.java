/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.dao;

import com.ufrn.testmaven.interfaces.iFilmeDao;
import com.ufrn.testmaven.model.Filme;

/**
 *
 * @author Hudson
 */
public class FilmeDaoImpl extends GenericDaoImpl <Filme, Integer> implements iFilmeDao{

    public FilmeDaoImpl() {
        super(Filme.class);
    }
    
}
