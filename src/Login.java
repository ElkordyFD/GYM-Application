package src;

import java.util.ArrayList;

public class Login {
    public static Coach loginCoach(String username, String password, ArrayList<Coach>coaches) {
        Coach coach = Searching.searchCoach(username, password, coaches);
        if (coach != null) {
            return coach;
        } else
            return coach; // return null
    }
    public static Customer loginCustomer(String username, String password, ArrayList<Customer>customers) {
        Customer customer = Searching.searchCustomer(username,password,customers);
        if(customer != null) {
            return customer;
        } else
            return customer; // return null
    }

}
