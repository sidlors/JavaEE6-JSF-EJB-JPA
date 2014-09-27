/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sidlors.bussines.session;

import com.sidlors.entities.Coffees;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sidlors
 */
@Stateless
@LocalBean
public class CoffeeManager {
    
    @PersistenceContext(unitName = "CoffeeApp-ejbPU")
    private EntityManager em;
    
    

    public List<Coffees> getAllCoffees() {
        Query query = em.createNamedQuery("Coffees.findAll");  
        return query.getResultList(); 
    }

    public Coffees update(Coffees coffees) {
        return em.merge(coffees); 
    }

    public void persist(Object object) {
        em.persist(object);
    }

    
}
