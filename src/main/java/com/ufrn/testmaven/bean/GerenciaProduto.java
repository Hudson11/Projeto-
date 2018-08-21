/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.testmaven.bean;



import com.ufrn.testmaven.dao.FilmeDaoImpl;
import com.ufrn.testmaven.dao.LivroDaoImpl;
import com.ufrn.testmaven.interfaces.iFilmeDao;
import com.ufrn.testmaven.interfaces.iLivroDao;
import com.ufrn.testmaven.model.Filme;
import com.ufrn.testmaven.model.Livro;
import com.ufrn.testmaven.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;


/**
 *
 * @author Hudson
 */

@ManagedBean
@ApplicationScoped
public class GerenciaProduto {
    
    Filme filme;
    Livro livro;
    List<Filme> listafilme;
    List<Livro> listalivro;

    
    public GerenciaProduto(){
        
        this.filme = new Filme();
        this.livro = new Livro();
        
        this.listafilme = new ArrayList<Filme>();
        this.listalivro = new ArrayList<Livro>();
        
    }
    
    iFilmeDao filmedao;
    iLivroDao livrodao;

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
   
    
    //Métodos de cadastro de Livros e Filmes
    
    //ERROR
    public String cadastraFilme(){
        filmedao = new FilmeDaoImpl();
        
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        
        filmedao.save(filme);
        sessao.close();
        
        filme = new Filme();
        return "/gerente/AbaFilmeGerente.xhtml";
    }
    
    //OK
    public String cadastraLivro(){
        livrodao = new LivroDaoImpl();
        
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        livrodao.save(livro);
        sessao.close();
        
        livro = new Livro();
        return "/gerente/AbaLivroGerente.xhtml";
    }
    
    //ERROR
    public void removerFilme(Filme f){
        filmedao = new FilmeDaoImpl();
        
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();

        filmedao.delete(f);

        sessao.close();
    }
    
    //ERROR
    public void removerLivro(Livro l){
        livrodao = new LivroDaoImpl();

        livrodao.delete(l);
    }   
    
    //Mêtodos de lista de objetos de livros e filmes
    public List<Filme> getListaFilme(){
        filmedao = new FilmeDaoImpl();
        
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listafilme = filmedao.findAll();
        
        sessao.close();
        return listafilme;
    }
    
    //OK
    public List<Livro> getListaLivro(){
        livrodao = new LivroDaoImpl();
        
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listalivro = livrodao.findAll();
        
        sessao.close();
        return listalivro;
    }
    
    //OK
    public List<Filme> getListaFilmes(){
        filmedao = new FilmeDaoImpl();
        
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listafilme = filmedao.findAll();
        
        sessao.close();
        return listafilme;
    }

    public List<Filme> getListafilme() {
        return listafilme;
    }

    public void setListafilme(List<Filme> listafilme) {
        this.listafilme = listafilme;
    }

    public List<Livro> getListalivro() {
        return listalivro;
    }

    public void setListalivro(List<Livro> listalivro) {
        this.listalivro = listalivro;
    }

    public iFilmeDao getFilmedao() {
        return filmedao;
    }

    public void setFilmedao(iFilmeDao filmedao) {
        this.filmedao = filmedao;
    }

    public iLivroDao getLivrodao() {
        return livrodao;
    }

    public void setLivrodao(iLivroDao livrodao) {
        this.livrodao = livrodao;
    }
}
