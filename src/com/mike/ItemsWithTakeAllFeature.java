package com.mike;

public class ItemsWithTakeAllFeature extends ItemsWithDiscount {
    
    private int N;
    private double retailPrice;
    private double unitPrice;
    
    public ItemsWithTakeAllFeature(String name, double unitPrice, double retailPrice) {
        super(name, unitPrice);
        N = 1;
        this.retailPrice = retailPrice;
        this.unitPrice = unitPrice;
        this.price = N * unitPrice;
        this.discount = calculateDiscount();
    }
    
    public ItemsWithTakeAllFeature(String name, double unitPrice, int minimumQuantity, double retailPrice) {
        super(name, unitPrice);
        N = minimumQuantity;
        this.retailPrice = retailPrice;
        this.unitPrice=unitPrice;
        this.price = N*unitPrice;
        this.discount = calculateDiscount();
    }
    
    
    @Override
    //TODO:translate menu here
    public String printInfo() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id: ").append(id)
                .append("name: ").append(name)
                .append("unit price: ").append(price)
                .append("minimum quantity: ").append(N)
                .append("total price: ").append(price)
                .append("discount: ").append(calculateDiscount());
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public double getDiscount() {
        return discount;
    }
    
    public int getN() {
        return N;
    }
    
    public void setN(int n) {
        N = n;
    }
    
    @Override
    public double calculateDiscount() {
        return (unitPrice - retailPrice) * N;
    }
}
