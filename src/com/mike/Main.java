package com.mike;

import com.mike.exception.BasketException;
import com.mike.exception.ItemException;

import java.time.LocalDateTime;
import java.util.*;

import static com.mike.MenuController.*;
import static com.mike.Store.basketList;


public class Main {
    public static final List<User> users = new ArrayList<>();
    public static final List<User> managers = new ArrayList<>();
    public static LocalDateTime loginTime;
    public static LocalDateTime logoutTime;
    public static String currentUser;

    public static void main(String[] args) {
        initialize(users, managers);
        showLoginMenu();

    }

    public static void showLoginMenu() {
        String input;
        String username;
        String password;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("======================LOGIN======================");
            System.out.println("Welcome to the Store Application (enter 'q' to quit)");
            System.out.println("Enter your username:");
            System.out.printf(">");
            username = in.nextLine();
            if(username.equals("q"))
                break;
            System.out.println("Enter your password:");
            System.out.printf(">");
            password = in.nextLine();
            if(password.equals("q"))
                break;
            if (authorize(username, password)) {
                currentUser = username;
                loginTime = LocalDateTime.now();
                showLanguageSelectionMenu();
                return;
            }

        } while (!in.nextLine().equals("q"));
    }


    public static void showLanguageSelectionMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("======================LANGUAGE======================");
        System.out.println("Choose Language: ");
        System.out.println("1) English \n2) Dutch");
        System.out.println("====================================================");
        System.out.printf(">");
        switch (in.nextInt()) {
            case 1:
                Locale.setDefault(new Locale("en", "US"));
                showMainMenu();
                break;
            case 2:
                Locale.setDefault(new Locale("nl", "NL"));
                showMainMenu();
                break;
            default:
                System.err.println("Unrecognized option");
                showLanguageSelectionMenu();
        }
    }

    public static void showMainMenu() {
        ResourceBundle menuBundle = ResourceBundle.getBundle("MenuBundle");
        Basket basket = null;
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n======================<MAIN MENU>======================\n")
                        .append("1)" + menuBundle.getString("newBasket") + "\n")
                        .append("2)" + menuBundle.getString("insertItem") + "\n")
                        .append("3)" + menuBundle.getString("removeItem") + "\n")
                        .append("4)" + menuBundle.getString("printBasket") + "\n")
                        .append("5)" + menuBundle.getString("promoMessage") + "\n")
                        .append("6)" + menuBundle.getString("exit"))
                        .append("\n=======================================================\n");
                System.out.println(sb.toString());
                System.out.printf(">");
                switch (in.nextInt()) {
                    case 1:
                        // create a basket
                        basket = createBasketMenuDisplay();
                        basketList.add(basket);
                        break;
                    case 2:
                        // insert an item
                        insertItemMenuDisplay(basket);
                        break;
                    case 3:
                        // remove an item
                        removeItemMenuDisplay(basket);
                        break;
                    case 4:
                        // print basket details
                        printBasketMenuDisplay(basket);
                        break;
                    case 5:
                        // apply promo discount
                        applyPromoMenuDisplay(basket);
                        break;
                    case 6:
                        // exit / logout
                        logoutTime = LocalDateTime.now();
                        return;
                    default:
                        System.err.println("Unrecognized option");
                        break;
                }
            }
        } catch (BasketException bax) {
            bax.setMessage("Basket not found exception").printCause();
        } catch (ItemException iex) {
            iex.setMessage("Item not found exception").printCause();
        } catch (Exception e) {
            System.out.println("Something went wrong. Try again.");
        }
    }

    private static void initialize(List<User> users, List<User> managers) {
        // creating 5 fixed cashiers
        User admin = new Cashier("Mike", "Bogdanov", "mbv", "mbv", "US", "445", 1500.0, 0);
        User user_db = new Cashier("John", "Spencer", "john", "john", "US", "837", 1500.0, 0);
        User user_test = new Cashier("Tom", "Clifford", "tom", "tom", "Finland", "774", 1500.0, 0);
        User user_dev = new Cashier("Mary", "Bauer", "mary", "mary", "UK", "384", 1500.0, 0);
        User user_client = new Cashier("Anna", "Peterson", "anna", "anna", "Spain", "664", 1500.0, 0);
        //creating 5 fixed managers
        User mg_db = new Manager("Raul", "Schultz", "raul", "raul", "US", "123");
        User mg_test = new Manager("Ferdinand", "Bayer", "ferd", "ferd", "Germany", "456");
        User mg_dev = new Manager("Paul", "Ford", "paul", "paul", "Italy", "789");
        User mg_client = new Manager("David", "Hoffman", "david", "david", "Denmark", "840");
        User mg_support = new Manager("Susan", "Anderson", "susan", "susan", "Sweden", "295");
        users.addAll(Arrays.asList(admin, user_db, user_client, user_dev, user_test));
        managers.addAll(Arrays.asList(mg_client, mg_db, mg_dev, mg_support, mg_test));
    }


    public static boolean authorize(String username, String password) {
        if (users.stream().anyMatch(u -> u.getUserName().equals(username) && u.getPassword().equals(password))) {
            return true;
        }
        if (managers.stream().anyMatch(u -> u.getUserName().equals(username) && u.getPassword().equals(password))) {
            return true;
        }

        System.out.print("username/password is not correct. press 'Enter' to continue");
        return false;
    }


    }





