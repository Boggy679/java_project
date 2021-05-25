package com.mike;

public class BasketForLoyalCustomers extends Basket {
    private int points;
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points += (int) (getTotalAmount() / 5);
    }
    
    @Override
    public double pay() {
        return getNetAmount() - ((points / 100) * 10);
    }
}

