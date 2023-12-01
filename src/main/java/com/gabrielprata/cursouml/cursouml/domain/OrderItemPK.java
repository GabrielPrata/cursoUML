package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Notação utilizada para dizer que essa classe é um subtipo
@Embeddable
public class OrderItemPK implements Serializable{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="order_id")
    private CustomerOrder Order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product Product;
    
    @JsonIgnore
    public CustomerOrder getOrder() {
        return Order;
    }
    public void setOrder(CustomerOrder order) {
        Order = order;
    }
    public Product getProduct() {
        return Product;
    }
    public void setProduct(Product product) {
        Product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Order == null) ? 0 : Order.hashCode());
        result = prime * result + ((Product == null) ? 0 : Product.hashCode());
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
        OrderItemPK other = (OrderItemPK) obj;
        if (Order == null) {
            if (other.Order != null)
                return false;
        } else if (!Order.equals(other.Order))
            return false;
        if (Product == null) {
            if (other.Product != null)
                return false;
        } else if (!Product.equals(other.Product))
            return false;
        return true;
    }

    
}
