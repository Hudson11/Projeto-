/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.dao;

import com.ufrn.testmaven.interfaces.iLivroDao;
import com.ufrn.testmaven.model.Livro;

/**
 *
 * @author Hudson
 */
public class LivroDaoImpl extends GenericDaoImpl <Livro, Integer> implements iLivroDao{

    public LivroDaoImpl() {
        super(Livro.class);
    }
    
}
