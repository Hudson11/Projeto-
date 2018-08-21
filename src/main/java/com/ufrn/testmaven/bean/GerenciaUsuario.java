/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.bean;

import com.ufrn.testmaven.dao.AutenticaDaoImpl;
import com.ufrn.testmaven.dao.ClienteDaoImpl;
import com.ufrn.testmaven.dao.GerenteDaoImpl;
import com.ufrn.testmaven.interfaces.iAutenticaDao;
import com.ufrn.testmaven.interfaces.iClienteDao;
import com.ufrn.testmaven.interfaces.iGerenteDao;
import com.ufrn.testmaven.model.Autentica;
import com.ufrn.testmaven.model.Cliente;
import com.ufrn.testmaven.model.Gerente;
import com.ufrn.testmaven.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import org.hibernate.Session;

/**
 *
 * @author Hudson
 */
@ManagedBean
@ApplicationScoped
public class GerenciaUsuario {
    
    Cliente c;
    Gerente g;
    Autentica t;
    
    ArrayList<Cliente> listacliente;
    ArrayList<Gerente> listagerente; 
    ArrayList<Autentica> listaautentica;
    
    String nome;
    String email;
    String cpf;
    
    
    public GerenciaUsuario(){
        
        this.c = new Cliente();
        this.g = new Gerente();
        this.t = new Autentica();
        
        this.listacliente = new ArrayList<Cliente>();
        this.listagerente = new ArrayList<Gerente>();
        this.listaautentica = new ArrayList<Autentica>();
      
    }
    
    
    iClienteDao clientedao = new ClienteDaoImpl();
    iGerenteDao gerentedao = new GerenteDaoImpl();
    iAutenticaDao autenticadao = new AutenticaDaoImpl();
    
    public void PerfilCliente(Cliente c){
        
        nome = c.getNome();
        email = c.getEmail();
        cpf = c.getCpf();
        
    }

    public void PerfilGerente(Gerente c){
        
        nome = c.getNome();
        email = c.getEmail();
        cpf = c.getCpf();
        
    }
    
    
    //Mêtodos para cadastro de clientes e gerentes
    
    public String CadastraCliente(){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();

        t.setCliente(this.c);
        t.setGerente(null);
        
        clientedao.save(c);
        autenticadao.save(t);

        c = new Cliente();
        t = new Autentica();
        sessao.close();
        
        /*FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Cliente cadastrado com sucesso\n" + "Bem vindo: " + nome,null));*/
       return "/Login.xhtml?faces-redirect=true";
    }
    
    public String CadastraGerente(){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();

        t.setCliente(null);
        t.setGerente(this.g);
        
        gerentedao.save(g);
        autenticadao.save(t);

        g = new Gerente();
        t = new Autentica();
        sessao.close();
        
        /*FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Gerente cadastrado com sucesso\n" + "Bem vindo: " + nome ,null));*/
        return "/AbaGerente.xhtml?faces-redirect=true";
    }
    
    //Mêtodos para remoção de clientes e Gerentes

    public void removerClientePermanente(Cliente cliente){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        clientedao.delete(cliente);

        sessao.close();
    }
    
    public void removerGerentePermanente(Gerente gerente){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        gerentedao.delete(gerente);
        
        sessao.close();
    }
    
    public List<Cliente> getListaCliente(){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listacliente = (ArrayList<Cliente>) clientedao.findAll();
        
        sessao.close();
        return listacliente;
    }
    
    public List<Gerente> getListaGerente(){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listagerente = (ArrayList<Gerente>) gerentedao.findAll();
        
        sessao.close();
        return listagerente;
    }
    
    public List<Autentica> getListaAutentica(){
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listaautentica = (ArrayList<Autentica>) autenticadao.findAll();
        
        sessao.close();
        return listaautentica;
    }
    
    //Mêtodos de atualização de clientes e gerentes
    
    public void updateCliente(Cliente cliente){
        this.c = cliente;
    }
    
    public void updateGerente(Gerente gerente){
        this.g = gerente;
    }
    
    //Login
    
    public String Login(String username, String senha){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        
        getListaAutentica();
        
        for(Autentica a: this.listaautentica){
            if(a.getUsername().equals(username) && a.getSenha().equals(senha)){
                if(a.getCliente() != null){
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("Cliente", a);
                    PerfilCliente(a.getCliente());
                    return "/cliente/Home.xhtml?faces-redirect=true";
                }else{
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("Gerente", a);
                    PerfilGerente(a.getGerente());
                    return "/gerente/PaginaGerente.xhtml?faces-redirect=true";
                }
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Usuário ou Senha inválidos" ,null));
        return null;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Gerente getG() {
        return g;
    }

    public void setG(Gerente g) {
        this.g = g;
    }

    public Autentica getT() {
        return t;
    }

    public void setT(Autentica t) {
        this.t = t;
    }

    public iClienteDao getClientedao() {
        return clientedao;
    }

    public void setClientedao(iClienteDao clientedao) {
        this.clientedao = clientedao;
    }

    public iGerenteDao getGerentedao() {
        return gerentedao;
    }

    public void setGerentedao(iGerenteDao gerentedao) {
        this.gerentedao = gerentedao;
    }

    public iAutenticaDao getAutenticadao() {
        return autenticadao;
    }

    public void setAutenticadao(iAutenticaDao autenticadao) {
        this.autenticadao = autenticadao;
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
}
