package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.gabrielprata.cursouml.cursouml.domain.enums.PaymentStatus;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private int Id;
    private int Status;

    @OneToOne
    @JoinColumn(name="order_id")
    @MapsId
    private CustomerOrder Order;

    public Payment(){

    }

    public Payment(PaymentStatus status, CustomerOrder order) {
        Status = status.getCod();
        Order = order;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(Status);
    }

    public void setStatus(PaymentStatus status) {
        Status = status.getCod();
    }

    public CustomerOrder getOrder() {
        return Order;
    }

    public void setOrder(CustomerOrder order) {
        Order = order;
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
        Payment other = (Payment) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

    
}
