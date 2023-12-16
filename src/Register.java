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
        int workingHours;
        boolean checkWorkingHours = false;
        boolean checkEmail = false;
        System.out.print("Enter id: ");
        id = Validate.checkInt();
        System.out.print("Enter password: ");
        password = input.next();
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter gender: ");
        gender = Validate.getGender();
        System.out.print("Enter address: ");
        address = input.next();
        System.out.print("Enter phoneNumber: ");
        phoneNumber = input.next();
        do {
            if (checkEmail)
                System.out.println("Invalid email, the email must have '@' and '.com' ");
            System.out.print("Enter email: ");
            email = input.next();
            if(email.contains("@") && email.contains(".com"))
                checkEmail = false;
            else {
                checkEmail = true;
            }
        } while (checkEmail);
        do {
            System.out.print("Enter WorkingHours: ");
            workingHours = Validate.checkInt();
            if (workingHours>8) {
                System.out.println("The Coach work not exceed 8 hours");
                checkWorkingHours = true;
            } else
                checkWorkingHours = false;
        } while (checkWorkingHours);
        Coach coach = new Coach(id, password, name, gender, address, phoneNumber, email, workingHours);
        coaches.add(coach);
    }
    public static void registerCustomer(ArrayList<Customer>customers) {
        ArrayList<InBody> inBodies = new ArrayList<>();
        Subscription subscription = new Subscription();
        boolean checkEmail = false;
        System.out.print("Enter id: ");
        id = Validate.checkInt();
        System.out.print("Enter password: ");
        password = input.next();
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter gender: ");
        gender = Validate.getGender();
        System.out.print("Enter address: ");
        address = input.next();
        System.out.print("Enter phoneNumber: ");
        phoneNumber = input.next();
        do {
            if (checkEmail)
                System.out.println("Invalid email, the email must have '@' and '.com' ");
            System.out.print("Enter email: ");
            email = input.next();
            if(email.contains("@") && email.contains(".com"))
                checkEmail = false;
            else {
                checkEmail = true;
            }
        } while (checkEmail);
        Customer customer = new Customer(id, password, name, gender, address, phoneNumber, email, inBodies, subscription);
        customers.add(customer);
    }
}
