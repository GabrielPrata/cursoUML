package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;

    @JsonManagedReference
    // Relacionamento vários para um
    @ManyToOne
    // Defino o nome da chave estrangeira da tabela cidade
    @JoinColumn(name = "Uf_id")
    private UF Uf;

    public City() {
    }

    public City(int id, String name, UF uf) {
        Id = id;
        Name = name;
        Uf = uf;
    }

    public City(String name, UF uf) {
        Name = name;
        Uf = uf;
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

    public UF getUf() {
        return Uf;
    }

    public void setUf(UF uf) {
        Uf = uf;
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
        City other = (City) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

}
