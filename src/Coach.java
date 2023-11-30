package src;

import java.util.ArrayList;

public class Coach extends Person {
    private int workingHoursPerDay;
    private ArrayList<Customer> customers;

    public Coach() {
        this.customers=new ArrayList<>(10);
    }

}
