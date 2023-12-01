package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


//Serializable diz que os objetos da classe podem ser convertidos para uma sequência de bites
//Serve para converter os objetos em arquivos e trafegar em rede
//(É uma exigência do Java)
//Uso o @Entity para dizer ao Java que esta classe é uma entidade do JPA (Para impotar a classe para o BD)
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    // Criando uma tabela no banco de dados com base nos atributos da classe
    // Marcações para importar o atributo para o banco de dados
    // Uso o IDENTITY para gerar as chaves primárias
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;

    //Apenas digo que esse é "o outro lado" do mapeamento feito em categories
    @ManyToMany(mappedBy = "categories")
    //@JsonManagedReference serve para trazer os objetos referenciados a classe

    private List<Product> products = new ArrayList<>();

    public Category() {

    }

    public Category(int id, String name) {
        Id = id;
        Name = name;
    }

    public Category(String name) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
