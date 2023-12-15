package src;

import java.util.ArrayList;

public class Login {
    public static Coach loginCoach(String username, String password, ArrayList<Coach>coaches) {
        Coach coach = Searching.searchCoach(username, password, coaches);
        return coach;
    }
    public static Customer loginCustomer(String username, String password, ArrayList<Customer>customers) {
        Customer customer = Searching.searchCustomer(username,password,customers);
        return customer;
    }

}
