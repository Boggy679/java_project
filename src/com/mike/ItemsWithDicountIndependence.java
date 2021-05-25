package com.mike;

import java.util.ResourceBundle;


public class ItemsWithDicountIndependence extends ItemsWithDiscount {
    private double discountIndependence;
    
    public ItemsWithDicountIndependence(String name, double price, double discount, double discountIndependence) {
        super(name, price, discount);
        this.discountIndependence = discountIndependence;
    }
    
    public double getDiscountIndependence() {
        return discountIndependence;
    }
    
    public void setDiscountIndependence(double discountIndependence) {
        this.discountIndependence = discountIndependence;
    }
    
    @Override
    public double calculateDiscount() {
       this.discount += discountIndependence;
       return this.discount;
    }
    
    @Override
    public String printInfo() {
        ResourceBundle menuBundle = ResourceBundle.getBundle("MenuBundle");
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id: ").append(id)
                .append(menuBundle.getString("name")+": ").append(name)
                .append(menuBundle.getString("price")+": ").append(price)
                .append(menuBundle.getString("discount")+": ").append(discount);
        sb.append("}");
        return sb.toString();
    }
}
