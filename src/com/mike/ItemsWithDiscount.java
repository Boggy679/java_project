package com.mike;

public class ItemsWithDiscount extends Item {
    
    public ItemsWithDiscount(String name, double price, double discount) {
        super(name, price, discount);
    }
    
    public ItemsWithDiscount(String name, double price) {
       super(name, price);
    }
    
    @Override
    public String printInfo() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id: ").append(id)
                .append("name: ").append(getName())
                .append("price: ").append(getPrice())
                .append("discount: ").append(calculateDiscount());
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public double calculateDiscount() {
        return this.discount;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id: '").append(id)
                .append("' name: '").append(getName())
                .append("' price: '").append(getPrice())
                .append("' discount: '").append(calculateDiscount());
        sb.append("'}");
        return sb.toString();
    }
}
