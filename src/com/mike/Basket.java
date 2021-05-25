package com.mike;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mike.Main.currentUser;


public abstract class Basket implements Payable {
    private static int id;
    private double netAmount;
    private double totalAmount;
    private double VAT;
    private List<Item> items = new ArrayList<>();
    private LocalDateTime purchaseTime;
    private String address;
    private String nameOfCashier;
    
    public Basket() {
        this.VAT = 20;
        this.purchaseTime = LocalDateTime.now();
        this.nameOfCashier = currentUser;
    }
    
    public static int getId() {
        return id;
    }
    
    public static void setId(int id) {
        Basket.id = id;
    }
    
    public double getNetAmount() {
        this.netAmount =0;
        for (Item i : items) {
            netAmount += (i.getPrice() - i.getDiscount()) * (1 - VAT / 100);
        }
        return netAmount;
    }
    
    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }
    
    public double getTotalAmount() {
        this.totalAmount=0;
        for (Item i : items) {
            totalAmount += i.getPrice() * (1 - VAT / 100);
        }
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public double getVAT() {
        return VAT;
    }
    
    public void setVAT(double VAT) {
        this.VAT = VAT;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public void addItem(Item newItem) {
        this.items.add(newItem);
    }
    
    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }
    
    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getNameOfCashier() {
        return nameOfCashier;
    }
    
    public void setNameOfCashier(String nameOfCashier) {
        this.nameOfCashier = nameOfCashier;
    }
    
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    
    @Override
    public String toString() {
        return String.format("DETAILS:\n\nBasket {\nNET=%s," +
                "\n TOTAL=%s," +
                "\n VAT=%s," +
                "\n ITEMS=%s," +
                "\n PURCHASE DATE&TIME= %s," +
                "\n ADDRESS= %s'," +
                "\n CASHIER USERNAME='%s'\n}", getNetAmount(), getTotalAmount(), getVAT(), items.toString(), getPurchaseTime(), getAddress(), getNameOfCashier());
    }
}
