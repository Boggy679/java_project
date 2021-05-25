package com.mike;

public class LoyalCustomer extends Customer {
    
    public LoyalCustomer(String name, String surname, String userName, String password, String address, String phoneNumber, int points, double bonus, Basket basket) {
        super(name, surname, userName, password, address, phoneNumber, points, bonus, basket);
    }
    
    @Override
    double calculateBonus() {
        double updatedBonus = getBonus() + ((getPoints() / 100) * 10);
        setBonus(updatedBonus);
        return updatedBonus;
    }
    
    @Override
    void printInfo() {
        System.out.println( super.toString());
    }
}
