package src;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private final String username = "admin";
    private final String password = "admin";
    static private int id;
    static private String pass;
    static private String name;
    static private char gender;
    static private String address;
    static private String phoneNumber;
    static private String email;
    static Scanner input = new Scanner(System.in);

    public static void addCoach(ArrayList<Coach> coaches) {
        int workingHours;
        boolean checkWorkingHours = false;
        boolean checkEmail = false;
        System.out.print("Enter id: ");
        id = Validate.checkInt();
        System.out.print("Enter password: ");
        pass = input.next();
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
            if(checkWorkingHours)
                System.out.println("Invalid data");
            System.out.print("Enter WorkingHours: ");
            workingHours = Validate.checkInt();
            if (workingHours>8) {
                System.out.println("The Coach work not exceed 8 hours");
                checkWorkingHours = true;
            } else
                checkWorkingHours = false;
        } while (checkWorkingHours);
        Coach coach = new Coach(id, pass, name, gender, address, phoneNumber, email, workingHours);
        coaches.add(coach);
    }

    public static void addCustomer(ArrayList<Customer> customers) {
        ArrayList<InBody> inBodies = new ArrayList<>();
        Subscription subscription = new Subscription();
        boolean checkEmail = false;
        System.out.print("Enter id: ");
        id = Validate.checkInt();
        System.out.print("Enter password: ");
        pass = input.next();
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
        Customer customer = new Customer(id, pass, name, gender, address, phoneNumber, email, inBodies, subscription);
        customers.add(customer);
    }

    public static void addEquipment(ArrayList<Equipment> equipments) {
        String name;
        String code;
        int quantity;
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter code: ");
        code = input.next();
        System.out.print("Enter quantity: ");
        quantity = Validate.checkInt();
        Equipment equipment = new Equipment(name, code, quantity);
        equipments.add(equipment);
    }

    public static void modify(Coach coach, int choice, ArrayList<Subscription> subscriptions, int coachId) {
        switch (choice) {
            case 1:
                System.out.println("Enter new id: ");
                int newId = input.nextInt();
                for (Subscription subscription : subscriptions) {
                    if (subscription.getAssignedCoachID() == coachId)
                        subscription.setAssignedCoachID(newId);
                }
                (coach).setId(newId);
                break;
            case 2:
                System.out.println("Enter new password: ");
                String password = input.nextLine();
                (coach).setPassword(password);
                break;
            case 3:
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                (coach).setName(name);
                break;
            case 4:
                System.out.println("Enter new gender: ");
                char gender = input.next().charAt(0);
                (coach).setGender(gender);
                break;
            case 5:
                System.out.println("Enter new address: ");
                String address = input.nextLine();
                (coach).setAddress(address);
                break;
            case 6:
                System.out.println("Enter new phoneNumber: ");
                String phoneNumber = input.nextLine();
                (coach).setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Enter new email: ");
                String email = input.nextLine();
                (coach).setEmail(email);
                break;
            case 8:
                System.out.println("Enter new WorkingHours: ");
                int workingHours = input.nextInt();
                (coach).setWorkingHoursPerDay(workingHours);
                break;
        }
    }

    public static void modify(Customer customer, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter new id: ");
                int newId = input.nextInt();
                (customer).setId(newId);
                (customer).getSubscription().setCustomerID(newId);
                break;
            case 2:
                System.out.println("Enter new password: ");
                String password = input.nextLine();
                (customer).setPassword(password);
                break;
            case 3:
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                (customer).setName(name);
                break;
            case 4:
                System.out.println("Enter new gender: ");
                char gender = input.next().charAt(0);
                (customer).setGender(gender);
                break;
            case 5:
                System.out.println("Enter new address: ");
                String address = input.nextLine();
                (customer).setAddress(address);
                break;
            case 6:
                System.out.println("Enter new phoneNumber: ");
                String phoneNumber = input.nextLine();
                (customer).setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Enter new email: ");
                String email = input.nextLine();
                (customer).setEmail(email);
                break;
            case 8:
        }
    }

    public static void modify(Equipment equipment, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                (equipment).setName(name);
                break;
            case 2:
                System.out.println("Enter new code: ");
                String code = input.next();
                (equipment).setCode(code);
                break;
            case 3:
                System.out.println("Enter new quantity: ");
                int quantity = input.nextInt();
                (equipment).setQuantity(quantity);
                break;
        }
    }

    public static void delete(Coach coach, ArrayList<Coach> coaches) {
        (coaches).remove(coach);
    }

    public static void delete(Customer customer, ArrayList<Customer> customers) {
        (customers).remove(customer);
    }

    public static void delete(Equipment equipment, ArrayList<Equipment> equipments) {
        (equipments).remove(equipment);
    }

    public static void showSubscriptionHistoryForACustomer(ArrayList<Customer> customers) {
        System.out.print("Enter customer's id: ");
        int customerId = Validate.checkInt();
        Customer customer = (Searching.searchCustomer(customers, customerId));
        if(customer == null)
            System.out.println("there is no Customer with this id");
        else
            System.out.println(customer.getSubscription());
    }

    public static void getCustomerInSpecificDate(ArrayList<Customer> c) {
        Scanner input = new Scanner(System.in);
        String date;
        System.out.print("Enter the date: ");
        date = input.next();
        ArrayList<Customer> customers = new ArrayList<>();
        String myDate;
        for (Customer customer : c) {
            myDate = DateFormating.dateFormatDayMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(date))
                customers.add(customer);
        }
        if (customers.size() != 0)
            DisplayObject.displayCustomers(customers);
        else
            System.out.println("No customers subscripted in this date");
    }

    public static void showGymIncomeInSpecificMonth(ArrayList<Customer> customers) {
        Scanner input = new Scanner(System.in);
        int income = 0;
        System.out.print("Enter date");
        String myDate = input.next();
        for (Customer customer : customers) {
            myDate = DateFormating.dateFormatMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(myDate)) {
                income += customer.getSubscription().getMembershipPlan().getPrice();
            }
        }
        System.out.println(income);
    }

    public static void showCustomerOfSpecificCoach(ArrayList<Subscription> subscriptions, ArrayList<Customer> customerss) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Coach's id: ");
        int coachId = Validate.checkInt();
        ArrayList<Customer> customers = new ArrayList<>();
        for (Subscription subscription : subscriptions) {
            if (subscription.getAssignedCoachID() == coachId) {
                customers.add(Searching.searchCustomer(customerss, subscription.getCustomerID()));
            }
        }
        if (customers.size() != 0)
            DisplayObject.displayCustomers(customers);
        else
            System.out.println("There is no Coach with this id");
    }
    public static int getCounterOfCustomerOfSpecificCoach(ArrayList<Subscription> subscriptions, int coachId) {
        int countOfCustomer=0;
        for (Subscription subscription : subscriptions) {
            if (subscription.getAssignedCoachID() == coachId) {
                countOfCustomer++;
            }
        }
        return countOfCustomer;
    }

    public static ArrayList<CoachRecord> getDescendingCoaches(ArrayList<Subscription>subscriptions, ArrayList<Coach>coaches) {
        ArrayList<CoachRecord> coachesRecord = new ArrayList<>();
        for (Coach coach:coaches) {
            CoachRecord coachRecord = new CoachRecord(coach.getId(),getCounterOfCustomerOfSpecificCoach(subscriptions,coach.getId()));
            coachesRecord.add(coachRecord);
        }
        return coachesRecord;
    }
    public static void showCoachesAssignedCustomer(ArrayList<Subscription>subscriptions,ArrayList<Coach>coaches) {
        ArrayList<CoachRecord> coachRecords = Admin.getDescendingCoaches(subscriptions,coaches);
        DisplayObject.displayDescendingCoaches(coachRecords,coaches);
    }
}