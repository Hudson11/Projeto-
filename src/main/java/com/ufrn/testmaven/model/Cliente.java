/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;




/**
 *
 * @author Hudson
 */
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    
    String nome;
    
    
    String email;
    
    
    String cpf;
    
    @OneToOne(mappedBy = "cliente", orphanRemoval = true)
    Autentica autentica;
    
    @OneToMany(orphanRemoval = true)
    @Cascade({CascadeType.ALL})  
    List<Pedido> listapedido;
   
    
    static int sequence = 1;
    

    public Cliente() {
    }

    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Cliente.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setDataRemocao(Date time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Autentica getAutentica() {
        return autentica;
    }

    public void setAutentica(Autentica autentica) {
        this.autentica = autentica;
    }

    public List<Pedido> getListapedido() {
        return listapedido;
    }

    public void setListapedido(List<Pedido> listapedido) {
        this.listapedido = listapedido;
    }
    
    
}
