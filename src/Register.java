package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    static Scanner input = new Scanner(System.in);
    static private int id;
    static private String password;
    static private String name;
    static private char gender;
    static private String address;
    static private String phoneNumber;
    static private String email;
    public static void registerCoach(ArrayList<Coach>coaches) {
        Admin.addCoach(coaches);
    }
    public static void registerCustomer(ArrayList<Customer>customers) {
        Admin.addCustomer(customers);
    }
}
