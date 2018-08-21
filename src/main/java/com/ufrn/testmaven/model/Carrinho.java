/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.model;

/**
 *
 * @author Hudson
 */

//OBS: esta classe nunca será uma Entidade do Banco de dados.

public class Carrinho {
    
    Filme f;
    Livro v;
    double valor;
    
    //OBS: A escolha do construtor na instância desse objeto dependerá diretamente do Cliente.

    public Carrinho(Livro v, double valor) {
        this.v = v;
        this.valor = valor;
    }

    public Carrinho(Filme f, double valor) {
        this.f = f;
        this.valor = valor;
    }
    
    public Carrinho(){}

    public Livro getV() {
        return v;
    }

    public void setV(Livro v) {
        this.v = v;
    }
    
    public Filme getF() {
        return f;
    }

    public void setF(Filme f) {
        this.f = f;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
