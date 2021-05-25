package com.mike;

import java.time.temporal.ChronoUnit;

import static com.mike.Main.loginTime;
import static com.mike.Main.logoutTime;


public class Cashier extends User {
    
    private double baseSalary;
    private long hoursOfWork;
    private double bonus;
    
    public Cashier(String name, String surname, String userName, String password, String address, String phoneNumber, double baseSalary, double bonus) {
        super(name, surname, userName, password, address, phoneNumber);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.setUserRole(UserRole.ROLE_CASHIER);
    }
    
    public double calculateBonus() {
        return hoursOfWork > 8 ? bonus + (hoursOfWork - 8) * 10 : bonus;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public long getHoursOfWork() {
        return (logoutTime.until(loginTime, ChronoUnit.HOURS));
    }
    
    public void setHoursOfWork(long hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
