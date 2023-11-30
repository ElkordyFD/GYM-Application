package src;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;

public class Coach extends Person implements Serializable {
    private int workingHoursPerDay;
    private ArrayList<Customer> customers;

    public Coach(int id, String password, String name, char gender, String address, String phoneNumber, String email, int workingHoursPerDay, ArrayList<Customer> customers) {
        super(id, password, name, gender, address, phoneNumber, email);
        this.workingHoursPerDay = workingHoursPerDay;
        this.customers = customers;
    }

    public Coach(int id, String password, String name, char gender, String address, String phoneNumber, String email) {
        super(id, password, name, gender, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "workingHoursPerDay=" + workingHoursPerDay +
                ", customers=" + customers +
                '}';
    }
}