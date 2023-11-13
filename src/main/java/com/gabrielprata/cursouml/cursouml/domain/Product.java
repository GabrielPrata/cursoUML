package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Name;
    private double Price;

    //Omite a lista de categorias, pois já foi referenciado do outro lado (classe Category)
    @JsonBackReference
    //Notações usadas para fazer o relacionamento muitos para muitos no banco de dados
    //name = "" - Nome da tabela que irá fazer o relacionamento
    //joinColumns = "" - Nome da chave estrangeira
    //inverseJoinColumns = "" - Nome da outra FK que referencia a categoria
    @ManyToMany
    @JoinTable(
        name="PRODUCT_CATEGORY",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Product(){

    }

    public Product(int id, String name, double price) {
        Id = id;
        Name = name;
        Price = price;
    }

    public Product(String name, double price) {
        Name = name;
        Price = price;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
        Product other = (Product) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

}
