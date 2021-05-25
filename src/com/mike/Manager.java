package com.mike;

public class Manager extends User {
    private int points;
    private String internalPhoneNumber;
    private int pinCode;
    
    public Manager(String name, String surname, String userName, String password, String address, String phoneNumber) {
        super(name, surname, userName, password, address, phoneNumber);
        setUserRole(UserRole.ROLE_MANAGER);
    }
}
