/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;

/**
 *
 * @author Hudson
 */

@Entity
@Table(name="Gerente")
public class Gerente implements Serializable{

    String nome;
    String email;
    String cpf;
    
    @OneToOne(mappedBy = "cliente", orphanRemoval = true)
    Autentica autentica;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    
    
    static int sequence = 1;

    public Gerente() {
    }

    public Gerente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.id = sequence++;
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

    public void setId(int codCliente) {
        this.id = codCliente;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Gerente.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
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
        final Gerente other = (Gerente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
