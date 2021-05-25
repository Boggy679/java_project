package com.mike;

public class ItemsWithBuyMorePayLessFeature extends ItemsWithDiscount {
    
    // if customer orders {amountToBuy} then he has to pay for {amountToPay}
    private int amountToBuy;
    private int amountToPay;
    private double unitPrice;
    
    public ItemsWithBuyMorePayLessFeature(String name, double unitPrice, int amountToBuy, int amountToPay) {
        super(name, unitPrice);
        this.amountToBuy = amountToBuy > 10 ? 10 : amountToBuy;
        this.amountToPay = amountToPay;
        this.unitPrice=unitPrice;
        this.price = this.amountToBuy*unitPrice;
        this.discount = calculateDiscount();
    }
    
    @Override
    public String printInfo() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("td: ").append(id)
                .append("name: ").append(name)
                .append("price: ").append(price)
                .append("discount: ").append(discount);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public double calculateDiscount() {
        return (amountToBuy - amountToPay) * this.unitPrice;
    }
}