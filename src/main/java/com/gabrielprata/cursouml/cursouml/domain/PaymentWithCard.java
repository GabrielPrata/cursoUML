package com.gabrielprata.cursouml.cursouml.domain;

import javax.persistence.Entity;

import com.gabrielprata.cursouml.cursouml.domain.enums.PaymentStatus;

@Entity
public class PaymentWithCard extends Payment{
    private static final long serialVersionUID = 1L;
    
    private int InstallmentsNumber;

    public PaymentWithCard(){

    }

    public PaymentWithCard(PaymentStatus status, CustomerOrder order, int installmentsNumber) {
        super(status, order);
        InstallmentsNumber = installmentsNumber;
    }

    public int getInstallmentsNumber() {
        return InstallmentsNumber;
    }

    public void setInstallmentsNumber(int installmentsNumber) {
        InstallmentsNumber = installmentsNumber;
    }
}
