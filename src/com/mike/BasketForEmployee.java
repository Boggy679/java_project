package com.mike;

public class BasketForEmployee extends Basket {
    private int points;
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points += (int) (getTotalAmount() / 15);
    }
    
 
    
    @Override
    public double pay() {
        return getNetAmount() - ((points / 100) * 50);
    }
}
