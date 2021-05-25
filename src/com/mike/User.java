package com.mike;

public abstract class User {
    private String name;
    private String surname;
    private String userName;
    private String password;
    private String address;
    private String phoneNumber;
    private static UserRole userRole;
    
    public User(String name, String surname, String userName, String password, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public UserRole getUserRole() {
        return userRole;
    }
    
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString() {
        return
                new StringBuilder()
                        .append("\nname=: ").append(name)
                        .append(", surname: ").append(surname)
                        .append(", userName: ").append(userName)
                        .append(", address: ").append(address)
                        .append(", phoneNumber: ").append(phoneNumber)
                        .append('\n').toString();
    }
}
