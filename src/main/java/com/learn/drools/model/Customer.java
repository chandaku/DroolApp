package com.learn.drools.model;

public class Customer {

    public Customer(CustomerType type, int years) {
        this.type = type;
        this.years = years;
    }


    private CustomerType type;

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    private int years;

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
