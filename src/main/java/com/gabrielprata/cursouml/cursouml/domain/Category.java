package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;

//Serializable diz que os objetos da classe podem ser convertidos para uma sequência de bites
//Serve para converter os objetos em arquivos e trafegar em rede
//(É uma exigência do JAVA)

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Id;
    private String Name;

    public Category() {

    }

    public Category(int id, String name) {
        Id = id;
        Name = name;
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
        Category other = (Category) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

}
