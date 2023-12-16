package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    public static void registerCoach(ArrayList<Coach>coaches) {
        Admin.addCoach(coaches);
    }
    public static void registerCustomer(ArrayList<Customer>customers) {
        Admin.addCustomer(customers);
    }
}
