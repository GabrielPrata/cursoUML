package com.gabrielprata.cursouml.cursouml.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.gabrielprata.cursouml.cursouml.domain.enums.PaymentStatus;

@Entity
public class PaymentWithBankSlip extends Payment {
    private static final long serialVersionUID = 1L;
    
    private Date DeadLineDate;
    private Date PaymentDate;

    public PaymentWithBankSlip(){

    }

    public PaymentWithBankSlip(PaymentStatus status, CustomerOrder order, Date deadLineDate, Date paymentDate) {
        super(status, order);
        DeadLineDate = deadLineDate;
        PaymentDate = paymentDate;
    }

    public Date getDeadLineDate() {
        return DeadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        DeadLineDate = deadLineDate;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }

    
}
