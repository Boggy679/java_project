package com.mike;

public abstract class Item {
    private static int count = 0;
     int id;
     String name;
     double price;
     double discount;
    
    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        setId(++count);
    }
    
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        setId(++count);
    }
    
    public abstract String printInfo();
    public abstract double calculateDiscount();
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
