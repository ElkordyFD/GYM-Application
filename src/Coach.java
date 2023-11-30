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

    public int getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setWorkingHoursPerDay(int workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Coach" + super.toString() +
                "workingHoursPerDay=" + workingHoursPerDay +
                ", customers=" + customers +
                '}';
    }
}