package com.gabrielprata.cursouml.cursouml.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private Date Instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "Order")
    private Payment Payment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer Customer;

    @ManyToOne
    @JoinColumn(name = "address_delivery_id")
    private Address DeliveryAddres;

    public CustomerOrder() {

    }

    public CustomerOrder(int id, Date instant, Customer customer, Address deliveryAddres) {
        Id = id;
        Instant = instant;
        Customer = customer;
        DeliveryAddres = deliveryAddres;
    }

    public CustomerOrder(Date instant, Customer customer, Address deliveryAddres) {
        Instant = instant;
        Customer = customer;
        DeliveryAddres = deliveryAddres;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getInstant() {
        return Instant;
    }

    public void setInstant(Date instant) {
        Instant = instant;
    }

    public Payment getPayment() {
        return Payment;
    }

    public void setPayment(Payment payment) {
        Payment = payment;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }

    public Address getDeliveryAddres() {
        return DeliveryAddres;
    }

    public void setDeliveryAddres(Address deliveryAddres) {
        DeliveryAddres = deliveryAddres;
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
        CustomerOrder other = (CustomerOrder) obj;
        if (Id != other.Id)
            return false;
        return true;
    }

}
