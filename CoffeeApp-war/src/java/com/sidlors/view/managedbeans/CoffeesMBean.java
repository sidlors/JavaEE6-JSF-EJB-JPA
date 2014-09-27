/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sidlors.view.managedbeans;

import com.sidlors.bussines.session.CoffeeManager;
import com.sidlors.entities.Coffees;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sidlors
 */
@Named(value = "coffeesMBean")
@SessionScoped
public class CoffeesMBean implements Serializable {
    @EJB
    private CoffeeManager coffeeManager;
    /* models/properties */  
    private Coffees coffee; // for display/update/insert in a form  
    private List<Coffees> coffees; // for display in a datatable  
    

    /**
     * Creates a new instance of CoffeesMBean
     */
    public CoffeesMBean() {
    }
    
    /** 
     * returns coffees list for display in a datatable DataTable 
     * @return 
     */  
    public List<Coffees>getCustomers() {  
//        if((coffee == null) || (coffees.isEmpty()))            
//            refresh();  
        coffees=coffeeManager.getAllCoffees();
        return coffees;  
    }  
  
//    public void refresh() {  
//        tousLesComptes = coffeeManager.findAll();  
//    }  
  
    /** 
     * returns details of a coffee. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Coffees getDetails() {  
        return coffee;  
    }  
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param coffee 
     * @return 
     */  
    public String showDetails(Coffees coffee) {  
        this.coffee = coffee;  
        return "CoffeeDetails"; // will display CustomerDetails.xml JSF page  
    }  
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        coffee = coffeeManager.update(coffee);  
        return "CoffeeList"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     * @return 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "CoffeesList";  
    }  
    
}
