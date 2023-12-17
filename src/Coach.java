package src;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Coach extends Person implements Serializable {
    private int workingHoursPerDay;

    public Coach(int id, String password, String name, char gender, String address, String phoneNumber, String email, int workingHoursPerDay) {
        super(id, password, name, gender, address, phoneNumber, email);
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public int getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }



    public void setWorkingHoursPerDay(int workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public ArrayList<Customer> storeMyCustomer(ArrayList<Customer>customers,int coachId) {
        ArrayList<Customer> myCustomers = Searching.searchCustomers(customers,coachId);
        return myCustomers;
    }
    public void showMyCustomer(ArrayList<Customer>customers,int coachId) {
        ArrayList<Customer>myCustomers = storeMyCustomer(customers,coachId);
        DisplayObject.displayCustomers(myCustomers);
    }
    public void printInbodyHistoryforSpecificCustomer(ArrayList<Customer>customers,int coachId) {
        Scanner input= new Scanner(System.in);
        int myCustomerId;
        System.out.print("Enter customer ID: ");
        myCustomerId = Validate.checkInt();
        ArrayList<Customer>myCustomers = storeMyCustomer(customers,coachId);
        Customer customer = Searching.searchCustomer(myCustomers,myCustomerId);
        if (customer != null)
            DisplayObject.displayInBody(customer.getInBodies());
        else
            System.out.println("There is no customer with this ID");
    }
    public void printDetailsOfSpecificCustomerByName(ArrayList<Customer>customers,int coachID) {
        Scanner input= new Scanner(System.in);
        String name;
        System.out.print("Enter customer name: ");
        name = input.next();
        ArrayList<Customer> myCustomers = storeMyCustomer(customers,coachID);
        ArrayList<Customer> customer = Searching.searchCustomer(myCustomers,name);
        if (customer.size() != 0)
            DisplayObject.displayCustomers(customer);
        else
            System.out.println("There are no customer with this name");
    }
    public void showCustomersByGender(ArrayList<Customer>customers,int coachID) {
        Scanner input= new Scanner(System.in);
        char gender;
        System.out.print("Enter gender(M/F): ");
        gender = Validate.getGender();
        ArrayList<Customer>myCustomers = storeMyCustomer(customers,coachID);
        ArrayList<Customer> customer = Searching.searchCustomer(myCustomers,gender);
        if (customer.size() != 0)
            DisplayObject.displayCustomers(customer);
        else
            System.out.println("There aren't " + gender + " Customers");
    }

    @Override
    public String toString() {
        String s = "Coach:\n" +
                super.toString() +
                "Working Hours Per Day: " + workingHoursPerDay + "\n";
        return s;
    }
}