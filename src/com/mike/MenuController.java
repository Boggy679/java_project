package com.mike;

import java.util.*;


public class MenuController {
    static ResourceBundle menuBundle = ResourceBundle.getBundle("MenuBundle");
    
    public static Basket createBasketMenuDisplay() throws Exception{
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================BASKET======================\n")
                .append(menuBundle.getString("chooseBasketType") + "\n")
                .append("1)" + menuBundle.getString("loyalBasket") + "\n")
                .append("2)" + menuBundle.getString("employeeBasket"))
                .append("\n=================================================\n");
        System.out.println(sb.toString());
        switch (in.nextInt()) {
            case 1:
                return new BasketForLoyalCustomers();
            case 2:
                return new BasketForEmployee();
            default:
                System.err.println("Unrecognized option");
                return null;
        }
    }
    
    public static void insertItemMenuDisplay(Basket basket) throws Exception{
        Scanner in = new Scanner(System.in);
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n======================INSERT========================\n")
                    .append(menuBundle.getString("chooseItemType") + "\n")
                    .append("1)" + menuBundle.getString("itemWithDiscount") + "\n")
                    .append("2)" + menuBundle.getString("itemWithBPfeature") + "\n")
                    .append("3)" + menuBundle.getString("itemWithTakeAllFeature") + "\n")
                    .append("4)" + menuBundle.getString("itemWithDiscountIndependence") + "\n")
                    .append("5)" + menuBundle.getString("getBack"))
                    .append("\n=================================================\n")
            ;
            System.out.println(sb.toString());
            System.out.printf(">");
            switch (in.nextInt()) {
                case 1:
                    // insert item with discount
                    System.out.print("Name: ");
                    in.nextLine();
                    String name = in.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(in.nextLine());
                    System.out.print("Discount: ");
                    double discount = Double.parseDouble(in.nextLine());
                    basket.addItem(new ItemsWithDiscount(name, price, discount));
                    break;
                case 2:
                    // insert item with buyMorePayLess feature
                    System.out.print("Name: ");
                    in.nextLine();
                    name = in.nextLine();
                    System.out.print("Price: ");
                    price = Double.parseDouble(in.nextLine());
                    System.out.print("Amount to buy: ");
                    int amountToBuy = Integer.parseInt(in.nextLine());
                    System.out.print("Amount to pay: ");
                    int amountToPay = Integer.parseInt(in.nextLine());
                    basket.addItem(new ItemsWithBuyMorePayLessFeature(name, price, amountToBuy, amountToPay));
                    break;
                case 3:
                    // insert item with takeAll feature
                    System.out.print("Name: ");
                    in.nextLine();
                    name = in.nextLine();
                    System.out.print("Unit price: ");
                    double unitPrice = Double.parseDouble(in.nextLine());
                    System.out.print("Retail Price: ");
                    double retailPrice = Double.parseDouble(in.nextLine());
                    //
                    System.out.print("Minimum Quantity: ");
                    int minimumQuantity = Integer.parseInt(in.nextLine());
                    basket.addItem(new ItemsWithTakeAllFeature(name, unitPrice, minimumQuantity, retailPrice));
                    break;
                case 4:
                    // insert item with discount independence feature
                    System.out.print("Name: ");
                    in.nextLine();
                    name = in.nextLine();
                    System.out.print("Price: ");
                    price = Double.parseDouble(in.nextLine());
                    System.out.print("Discount: ");
                    discount = Double.parseDouble(in.nextLine());
                    System.out.print("Discount independence value: ");
                    double discountIndependence = Double.parseDouble(in.nextLine());
                    basket.addItem(new ItemsWithDicountIndependence(name, price, discount, discountIndependence));
                    break;
                case 5:
                    // return
                    return;
                default:
                    System.err.println("Unrecognized option");
                    break;
            }
        }
    }
    
    public static void printBasketMenuDisplay(Basket basket) {
        System.out.println(basket.toString());
    }
    
    public static void applyPromoMenuDisplay(Basket basket) throws Exception{
        List<Item> items = basket.getItems();
        items.stream().forEach(item -> item.setPrice(0.9 * item.getPrice()));
        System.out.println("\n ***** Christmas promo code: 10% is applied to net amount *****");
    }
    
    public static void removeItemMenuDisplay(Basket basket) throws Exception{
        System.out.println(basket.toString());
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================REMOVE======================\n")
                .append(menuBundle.getString("chooseItemId"))
                .append("\n==================================================\n")
        ;
        System.out.println(sb.toString());
        System.out.printf(">");
        int itemId = in.nextInt();
        List<Item> itemsInsideBasket = basket.getItems();
        boolean itemIsFound = itemsInsideBasket.stream().anyMatch(item -> item.getId() == itemId);
        if (itemIsFound) {
            Item foundItem = null;
            for (Item i : itemsInsideBasket) {
                if (i.getId() == itemId)
                    foundItem = i;
            }
            basket.removeItem(foundItem);
            
            System.out.println("****** Item with id: " + itemId + " is removed ******");
        } else {
            System.out.println("ID you entered does not exist in the basket");
        }
    }
}
