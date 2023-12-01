package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabrielprata.cursouml.cursouml.domain.enums.CustomerType;

@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Email;
    private String Document;
    private int Type;

    @OneToMany(mappedBy = "Customer")
    private List<Address> Addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEPHONE")
    private Set<String> Telephone = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "Customer")
    private List<CustomerOrder> Orders = new ArrayList<>();

    public Customer() {

    }

    @JsonIgnore
    public List<CustomerOrder> getOrders() {
        return Orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        Orders = orders;
    }

    public Customer(int id, String name, String email, String document, CustomerType type) {
        Id = id;
        Name = name;
        Email = email;
        Document = document;
        Type = type.getCod();
    }

    public Customer(String name, String email, String document, CustomerType type) {
        Name = name;
        Email = email;
        Document = document;
        Type = type.getCod();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public CustomerType getType() {
        return CustomerType.toEnum(Type);
    }

    public void setType(CustomerType type) {
        Type = type.getCod();
    }

    public List<Address> getAddresses() {
        return Addresses;
    }

    public void setAddresses(List<Address> addresses) {
        Addresses = addresses;
    }

    public Set<String> getTelephone() {
        return Telephone;
    }

    public void setTelephone(Set<String> telephone) {
        Telephone = telephone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

}
