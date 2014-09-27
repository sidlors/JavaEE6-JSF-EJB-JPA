/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sidlors.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sidlors
 */
@Entity
@Table(name = "SUPPLIERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findBySupId", query = "SELECT s FROM Suppliers s WHERE s.supId = :supId"),
    @NamedQuery(name = "Suppliers.findBySupName", query = "SELECT s FROM Suppliers s WHERE s.supName = :supName"),
    @NamedQuery(name = "Suppliers.findByStreet", query = "SELECT s FROM Suppliers s WHERE s.street = :street"),
    @NamedQuery(name = "Suppliers.findByCity", query = "SELECT s FROM Suppliers s WHERE s.city = :city"),
    @NamedQuery(name = "Suppliers.findByState", query = "SELECT s FROM Suppliers s WHERE s.state = :state"),
    @NamedQuery(name = "Suppliers.findByZip", query = "SELECT s FROM Suppliers s WHERE s.zip = :zip")})
public class Suppliers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUP_ID")
    private Integer supId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SUP_NAME")
    private String supName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "STREET")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STATE")
    private String state;
    @Size(max = 5)
    @Column(name = "ZIP")
    private String zip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supId")
    private Collection<Coffees> coffeesCollection;

    public Suppliers() {
    }

    public Suppliers(Integer supId) {
        this.supId = supId;
    }

    public Suppliers(Integer supId, String supName, String street, String city, String state) {
        this.supId = supId;
        this.supName = supName;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @XmlTransient
    public Collection<Coffees> getCoffeesCollection() {
        return coffeesCollection;
    }

    public void setCoffeesCollection(Collection<Coffees> coffeesCollection) {
        this.coffeesCollection = coffeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supId != null ? supId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.supId == null && other.supId != null) || (this.supId != null && !this.supId.equals(other.supId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sidlors.entities.Suppliers[ supId=" + supId + " ]";
    }
    
}
