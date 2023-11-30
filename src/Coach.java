package src;

import java.util.ArrayList;

public class Coach extends Person {
    private int workingHoursPerDay;
    private ArrayList<Customer> customers;

    public Coach(int id, String password, String name, char gender, String address, String phoneNumber, String email, int workingHoursPerDay, ArrayList<Customer> customers) {
        super(id, password, name, gender, address, phoneNumber, email);
        this.workingHoursPerDay = workingHoursPerDay;
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "workingHoursPerDay=" + workingHoursPerDay +
                ", customers=" + customers +
                '}';
    }
}