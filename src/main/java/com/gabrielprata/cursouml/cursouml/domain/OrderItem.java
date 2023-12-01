package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    //Notação usada pra indicar que é um ID embutido em um tipo auxiliar`
    @JsonIgnore
    @EmbeddedId
    private OrderItemPK Id = new OrderItemPK();

    private Double Discount;
    private int Quantity;
    private double Price;

    public OrderItem(){

    }

    public OrderItem(CustomerOrder order, Product product, Double discount, int quantity, double price) {
        Id.setOrder(order);
        Id.setProduct(product);
        Discount = discount;
        Quantity = quantity;
        Price = price;
    }

    @JsonIgnore
    public CustomerOrder getOrder(){
        return Id.getOrder();
    }
    
    public Product geProduct(){
        return Id.getProduct();
    }

    public OrderItemPK getId() {
        return Id;
    }

    public void setId(OrderItemPK id) {
        Id = id;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
        OrderItem other = (OrderItem) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        return true;
    }

    
}
