package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    static String username;
    static String password;
    static Scanner input = new Scanner(System.in);
    public static Object login(ArrayList<Customer>customers,ArrayList<Coach>coaches) {
        boolean valueChecked = false;
        boolean adminChecked = true;
        String admin = "admin";
        Object object = new Object();
        do {
            if (valueChecked)
                System.out.println("Invalid Data!\n");
            System.out.print("Enter username: ");
            username = input.next();
            System.out.print("Enter password: ");
            password = input.next();
            Coach userCoach = Searching.searchCoach(username,password,coaches);
            if (userCoach != null)
                object = userCoach;
            Customer userCustomer = Searching.searchCustomer(username,password,customers);
            if (userCustomer != null)
                object = userCustomer;
            if (username.equals(admin) && password.equals(admin))
                object = admin;
            else
                adminChecked = false;
            if (userCoach == null && userCustomer == null && adminChecked == false)
                valueChecked = true;
            else
                valueChecked = false;
        } while (valueChecked);
        return object;
    }
}