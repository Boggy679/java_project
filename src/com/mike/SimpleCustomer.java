package com.mike;

public class SimpleCustomer extends Customer {
    
    public SimpleCustomer(String name, String surname, String userName, String password, String address, String phoneNumber, int points, double bonus, Basket basket) {
        super(name, surname, userName, password, address, phoneNumber, points, bonus, basket);
    }
    
    @Override
    double calculateBonus() {
        return 0;
    }
    
    @Override
    void printInfo() {
        System.out.println( super.toString());
    }
}
