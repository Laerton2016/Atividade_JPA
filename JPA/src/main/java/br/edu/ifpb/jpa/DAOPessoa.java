/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jpa;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author laerton
 */
public class DAOPessoa {
    
    private EntityManager em = Persistence.createEntityManagerFactory("DACPU").createEntityManager();
    
    public void save (Pessoa p){
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update (Pessoa p){
        try {
            em.getTransaction().begin();
            p = em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public void remove (Pessoa p){
        try {
            em.getTransaction().begin();
            p =em.merge(p);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public Pessoa findById(int id ){
        return em.find(Pessoa.class, id);
    }
}
