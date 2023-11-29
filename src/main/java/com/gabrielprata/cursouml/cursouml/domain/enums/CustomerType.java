package com.gabrielprata.cursouml.cursouml.domain.enums;

public enum CustomerType {
    PESSSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int Cod;
    private String Desc;

    private CustomerType(int cod, String desc){
        Cod = cod;
        Desc = desc;
    }

    public int getCod(){
        return Cod;
    }

    public String getDesc(){
        return Desc;
    }

    public static CustomerType toEnum(int cod){
        for (CustomerType x : CustomerType.values()) {
            if (cod == x.getCod()) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ID: " + cod);
    }
}
