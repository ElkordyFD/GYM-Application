package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin {
    private final String username="admin";
    private final String password="admin";

    public static void add(Object object,GYM gym) {
        if(object instanceof Coach) {
            (gym.getCoaches()).add((Coach) object);
        } else if(object instanceof Customer) {
            (gym.getCustomers()).add((Customer) object);
        } else {
            (gym.getSports_equipment()).add((Equipment) object);
        }
    }
    public static void modify(Object object,int choice) {
        Scanner input = new Scanner(System.in);
        if(object instanceof Coach) {
            switch (choice) {
                case 1:
                    System.out.println("Enter new id: ");
                    int newId = input.nextInt();
                    ((Coach) object).setId(newId);
                    break;
                case 2:
                    System.out.println("Enter new password: ");
                    String password = input.nextLine();
                    ((Coach) object).setPassword(password);
                    break;
                case 3:
                    System.out.println("Enter new name: ");
                    String name = input.nextLine();
                    ((Coach) object).setName(name);
                    break;
                case 4:
                    System.out.println("Enter new gender: ");
                    char gender = input.next().charAt(0);
                    ((Coach) object).setGender(gender);
                    break;
                case 5:
                    System.out.println("Enter new address: ");
                    String address = input.nextLine();
                    ((Coach) object).setAddress(address);
                    break;
                case 6:
                    System.out.println("Enter new phoneNumber: ");
                    String phoneNumber = input.nextLine();
                    ((Coach) object).setPhoneNumber(phoneNumber);
                    break;
                case 7:
                    System.out.println("Enter new email: ");
                    String email = input.nextLine();
                    ((Coach) object).setEmail(email);
                    break;
                case 8:
                    System.out.println("Enter new WorkingHours: ");
                    int workingHours = input.nextInt();
                    ((Coach) object).setWorkingHoursPerDay(workingHours);
                    break;
            }
        } else if(object instanceof Customer) {
            switch (choice) {
                case 1:
                    System.out.println("Enter new id: ");
                    int newId = input.nextInt();
                    ((Customer) object).setId(newId);
                    break;
                case 2:
                    System.out.println("Enter new password: ");
                    String password = input.nextLine();
                    ((Customer) object).setPassword(password);
                    break;
                case 3:
                    System.out.println("Enter new name: ");
                    String name = input.nextLine();
                    ((Customer) object).setName(name);
                    break;
                case 4:
                    System.out.println("Enter new gender: ");
                    char gender = input.next().charAt(0);
                    ((Customer) object).setGender(gender);
                    break;
                case 5:
                    System.out.println("Enter new address: ");
                    String address = input.nextLine();
                    ((Customer) object).setAddress(address);
                    break;
                case 6:
                    System.out.println("Enter new phoneNumber: ");
                    String phoneNumber = input.nextLine();
                    ((Customer) object).setPhoneNumber(phoneNumber);
                    break;
                case 7:
                    System.out.println("Enter new email: ");
                    String email = input.nextLine();
                    ((Customer) object).setEmail(email);
                    break;
                case 8:

            }
        } else {
            switch (choice) {
                case 1:
                    System.out.println("Enter new name: ");
                    String name = input.nextLine();
                    ((Equipment) object).setName(name);
                    break;
                case 2:
                    System.out.println("Enter new code: ");
                    int code = input.nextInt();
                    ((Equipment) object).setCode(code);
                    break;
                case 3:
                    System.out.println("Enter new quantity: ");
                    int quantity = input.nextInt();
                    ((Equipment) object).setQuantity(quantity);
                    break;
            }
        }
    };
    public static void delete(Object object,GYM gym) {
        if(object instanceof Coach) {
            (gym.getCoaches()).remove((Coach) object);
        } else if(object instanceof Customer) {
            (gym.getCustomers()).remove((Customer) object);
        } else {
            (gym.getSports_equipment()).remove((Equipment) object);
        }
    }
    public static ArrayList<Customer> getCustomerInSpecificMonth(ArrayList<Customer>c,String date) {
        ArrayList<Customer> customers=new ArrayList<>();
        String myDate;
        for (Customer customer:c) {
            myDate = DateFormating.dateFormatMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(date))
                customers.add(customer);
        }
        return customers;
    }
    public static int getGymIncome(GYM gym,String date) {
        int income=0;
        String myDate;
        for (Customer customer: gym.getCustomers()) {
            myDate = DateFormating.dateFormatMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if(myDate.equals(date)) {
                income+=customer.getSubscription().getMembershipPlan().getPrice();
            }
        }
        return income;
    }
    public static ArrayList<Customer> getCustomerOfSpecificCoach(GYM gym,int id) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (Subscription subscription:gym.getSubscriptions()) {
            if(subscription.getAssignedCoachID()==id){
                customers.add(Searching.searchCustomer(gym.getCustomers(),subscription.getCustomerID()));
            }
        }
        return customers;
    }






}