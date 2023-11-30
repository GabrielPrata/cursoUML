package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String PublicPlace;
    private String Number;
    private String Complement;
    private String Neighborhood;
    private String Cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer Customer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City City;

    public City getCity() {
        return City;
    }

    public void setCity(City city) {
        City = city;
    }

    public Address() {

    }

    public Address(int id, String publicPlace, String number, String complement, String neighborhood, String cep,
            Customer customer, City city) {
        Id = id;
        PublicPlace = publicPlace;
        Number = number;
        Complement = complement;
        Neighborhood = neighborhood;
        Cep = cep;
        Customer = customer;
        City = city;
    }

    public Address(String publicPlace, String number, String complement, String neighborhood, String cep,
            Customer customer, City city) {
        PublicPlace = publicPlace;
        Number = number;
        Complement = complement;
        Neighborhood = neighborhood;
        Cep = cep;
        Customer = customer;
        City = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPublicPlace() {
        return PublicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        PublicPlace = publicPlace;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getComplement() {
        return Complement;
    }

    public void setComplement(String complement) {
        Complement = complement;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        Neighborhood = neighborhood;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    @JsonIgnore
    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
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
        Address other = (Address) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

    

}
