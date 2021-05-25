package com.mike;

public abstract class Customer extends User {
    private int points;
    private double bonus;
    private Basket basket;
    
    public Customer(String name, String surname, String userName, String password, String address, String phoneNumber, int points, double bonus, Basket basket) {
        super(name, surname, userName, password, address, phoneNumber);
        this.points = points;
        this.bonus = bonus;
        this.basket = basket;
    }
    
    abstract double calculateBonus();
    
    abstract void printInfo();
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public Basket getBasket() {
        return basket;
    }
    
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Customer:\n")
                .append("points=").append(points)
                .append(", bonus=").append(bonus)
                .append(", basket=").append(basket)
                .append(super.toString()).toString();
    }
}
