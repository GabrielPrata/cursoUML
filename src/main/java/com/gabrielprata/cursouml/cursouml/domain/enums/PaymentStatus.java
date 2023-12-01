package com.gabrielprata.cursouml.cursouml.domain.enums;

public enum PaymentStatus {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int Cod;
    private String Desc;

    private PaymentStatus(int cod, String desc){
        Cod = cod;
        Desc = desc;
    }

    public int getCod(){
        return Cod;
    }

    public String getDesc(){
        return Desc;
    }

    public static PaymentStatus toEnum(int cod){
        for (PaymentStatus x : PaymentStatus.values()) {
            if (cod == x.getCod()) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ID: " + cod);
    }
}